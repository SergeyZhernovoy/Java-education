/**
*@author Sergey Zhernovoy
*@since 01-07-2016
*это класс хранения заявок 
*/

package ru.szhernovoy.models;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.*;
import java.sql.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;


public class Tracker {

	private String url;
	private String userName;
	private String password;
	private String port;
	private Connection conn = null;
	private final String fileProperties;
	private static Logger Log = LoggerFactory.getLogger(Tracker.class);

	public Tracker(final String properties) {
		this.fileProperties = properties;
		this.connect();
	}

	public boolean connect()  {
		boolean result = false;

		if(!getProperties()){
			return result;
		}

		Properties props = new Properties();
		props.setProperty("user",this.userName);
		props.setProperty("password",this.password);
		props.setProperty("ssl","true");
		try {
			conn = DriverManager.getConnection(this.url, props);
			this.createStructure();
			result = true;
		} catch (SQLException e) {
			Log.error(e.getMessage(),e);
		}
		return result;
	}

	public void createStructure(){

	}


	public boolean getProperties(){
		boolean result = false;
/*
		try {
			FileReader fileReader = new FileReader(this.fileProperties);
			while(fileReader.read()  > 0 )
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
		return result;

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
			rs = st.executeQuery();
			item.setId(String.valueOf(st.executeUpdate()));
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

	public Item[] getAll(){
		
		Item[] result = null;//new Item[];// позиция всегда указывает на пустой или возможно пустой элемент
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM task");
			rs = st.executeQuery();
			int position = 0;
			result = new Item[rs.getFetchSize()];
			while (rs.next()) {
				result[position] = new Item(rs.getString("name"),rs.getString("description"), rs.getTimestamp("create_date").getTime());
				result[position++].setId(String.valueOf(rs.getInt("task_id")));
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
	
	public Item[] findByFilter(String name){

		Item[] result = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM task WHERE name = ?");
			st.setString(1,name);
			rs = st.executeQuery();
			int position = 0;
			result = new Item[rs.getFetchSize()];
			while (rs.next()) {
				result[position] = new Item(rs.getString("name"),rs.getString("description"), rs.getTimestamp("create_date").getTime());
				result[position++].setId(String.valueOf(rs.getInt("task_id")));
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
	
	public Item[] findByFilter(String name, String decr){

		Item[] result = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM task WHERE name = ? AND description = ?");
			st.setString(1,name);
			st.setString(2,decr);
			rs = st.executeQuery();
			int position = 0;
			result = new Item[rs.getFetchSize()];
			while (rs.next()) {
				result[position] = new Item(rs.getString("name"),rs.getString("description"), rs.getTimestamp("create_date").getTime());
				result[position++].setId(String.valueOf(rs.getInt("task_id")));
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
				st = conn.prepareStatement("UPDATE task SET name = ?, description = ? , create_date = ? WHERE task_id = ?");
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
			st = conn.prepareStatement("INSERT INTO commentary(text,task_id) VALUES (?,?)",Statement.RETURN_GENERATED_KEYS);
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
	
	public String[] getCommentary(String id){
	
		String[] result =null;

			
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