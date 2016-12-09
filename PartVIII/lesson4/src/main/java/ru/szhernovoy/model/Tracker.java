/**
*@author Sergey Zhernovoy
*@since 01-07-2016
*это класс хранения заявок 
*/

package ru.szhernovoy.model;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;


public class Tracker {

	private Connection conn = null;
	private final String fileProperties = String.format("%s%sTracker.properties",System.getProperty("user.home"), File.separator);
	private final static Logger Log = LoggerFactory.getLogger(Tracker.class);

	public boolean connect()  {
		boolean result = false;
		Properties props = getProperties();
		try {
			conn = DriverManager.getConnection(props.getProperty("url"), props);
			this.createStructure();
			result = true;
		} catch (SQLException e) {
			Log.error(e.getMessage(),e);
		}
		return result;
	}

	public void createStructure(){
        Statement st = null;
        try {
           st = conn.createStatement();
           st.execute("create table if not exists task (task_id serial primary key,name varchar(25) NOT NULL,description varchar (150),create_date timestamp NOT NULL)");
           st.execute("create table  if not exists commentary(comm_id serial primary key,comment text,task_id integer references task(task_id))");
        } catch (SQLException e) {
            Log.error(e.getMessage(),e);
        }
		finally {
			try{
				st.close();
			} catch (SQLException e) {
				Log.error(e.getMessage(),e);
			}
		}
    }

	public Properties getProperties() {

        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(this.fileProperties)) {
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            Log.error(e.getMessage(),e);
        } catch (IOException e) {
            Log.error(e.getMessage(),e);
        }

		return properties;
    }

	@Override
	protected void finalize() throws Throwable {
		this.close();
	}

	public Item addItem(Item item){
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("INSERT INTO task(name,description,create_date) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);
			st.setString(1,item.getName());
			st.setString(2,item.getDescr());
			st.setTimestamp(3,new Timestamp(item.getCreate()));
			st.executeUpdate();
			rs = st.getGeneratedKeys();
			if(rs.next()){
				item.setId(String.valueOf(rs.getInt("task_id")));
			}


		} catch (Exception e) {
			Log.error(e.getMessage(),e);
		}
		finally {
			try{
				rs.close();
				st.close();
			}
			catch (Exception e){
				Log.error(e.getMessage(),e);
			}
		}
		return item;
	}

	public Item findById(String id){
		Item result =null;

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM task WHERE task_id = ?");
			st.setInt(1,Integer.parseInt(id));
			rs = st.executeQuery();
			if (rs.next()) {
				result = new Item(rs.getString("name"),rs.getString("description"), rs.getTimestamp("create_date").getTime());
				result.setId(String.valueOf(rs.getInt("task_id")));
			}

		} catch (Exception e) {
			Log.error(e.getMessage(),e);
		}
		finally {
			try{
				rs.close();
				st.close();
			}
			catch (Exception e){
				Log.error(e.getMessage(),e);
			}
		}

		return result;		
	}

	public List<Item> getAll(){
		
		List<Item> result = new ArrayList<>();//new Item[];// позиция всегда указывает на пустой или возможно пустой элемент
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM task");
			rs = st.executeQuery();
			while (rs.next()) {

				Item item = new Item(rs.getString("name"),rs.getString("description"), rs.getTimestamp("create_date").getTime());
				item.setId(String.valueOf(rs.getInt("task_id")));
				result.add(item);
			}

		} catch (Exception e) {
			Log.error(e.getMessage(),e);
		}
		finally {
			try{
				rs.close();
				st.close();
			}
			catch (Exception e){
				Log.error(e.getMessage(),e);
			}
		}

		return result;
	}
	
	public List<Item> findByFilter(String name){

		List<Item> result = new ArrayList<>();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM task WHERE name = ?");
			st.setString(1,name);
			rs = st.executeQuery();

			while (rs.next()) {

				Item item = new Item(rs.getString("name"),rs.getString("description"), rs.getTimestamp("create_date").getTime());
				item.setId(String.valueOf(rs.getInt("task_id")));
				result.add(item);
			}

		} catch (Exception e) {
			Log.error(e.getMessage(),e);
		}
		finally {
			try{
				rs.close();
				st.close();
			}
			catch (Exception e){
				Log.error(e.getMessage(),e);
			}
		}

		return result;
	}

	public void deleteItem(Item item){
		String id = item.getId();
		if(id != null){
			PreparedStatement st = null;
			try {
				st = conn.prepareStatement("DELETE FROM task WHERE task_id = ?");
				st.setInt(1,Integer.valueOf(id));
				st.executeUpdate();
				st = conn.prepareStatement("DELETE FROM commentary WHERE task_id = ?");
				st.setInt(1,Integer.valueOf(id));
				st.executeUpdate();
			} catch (Exception e) {
				Log.error(e.getMessage(),e);
			}
			finally {
				try{
					st.close();
				}
				catch (Exception e){
					Log.error(e.getMessage(),e);
				}
			}
		}
	}
	
	public void updateItem(Item item){
		String id = item.getId();
		if(id != null){
			PreparedStatement st = null;
			try {
				st = conn.prepareStatement("UPDATE task SET name = ?, description = ? , create_date = ? WHERE task_id = ?");
				st.setString(1,item.getName());
				st.setString(2,item.getDescr());
				st.setTimestamp(3,new Timestamp(item.getCreate()));
				st.setInt(4,Integer.valueOf(id));
				st.executeUpdate();
			} catch (Exception e) {
				Log.error(e.getMessage(),e);
			}
			finally {
				try{
					st.close();
				}
				catch (Exception e){
					Log.error(e.getMessage(),e);
				}
			}
		}

	}
		
	public void addCommentary(Item item, String comm){
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("INSERT INTO commentary(comment,task_id) VALUES (?,?)",Statement.RETURN_GENERATED_KEYS);
			st.setString(1,comm);
			st.setInt(2,Integer.valueOf(item.getId()));
			rs = st.executeQuery();
		} catch (Exception e) {
			Log.error(e.getMessage(),e);
		}
		finally {
			try{
				rs.close();
				st.close();
			}
			catch (Exception e){
				Log.error(e.getMessage(),e);
			}
		}
	}
	
	public List<String> getCommentary(String id){
	
		List<String> result = new LinkedList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        if(id != null) {
            try {
                st = conn.prepareStatement("SELECT * FROM commentary WHERE task_id = ?");
                st.setInt(1, Integer.valueOf(id));
                rs = st.executeQuery();

                while (rs.next()) {
                    result.add(rs.getString("comment"));
                }

            } catch (Exception e) {
                Log.error(e.getMessage(), e);
            } finally {
                try {
                    rs.close();
                    st.close();
                } catch (Exception e) {
                    Log.error(e.getMessage(), e);
                }
            }
        }
		return result;
	}


	public boolean close(){
		boolean result = false;
		if(conn !=null ){
			try{
				conn.close();
				result = true;
			}
			catch(SQLException e){
				Log.error(e.getMessage(),e);
			}
		}
		return result;
	}

}