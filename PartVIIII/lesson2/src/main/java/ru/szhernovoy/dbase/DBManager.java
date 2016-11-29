/**
*@author Sergey Zhernovoy
*@since 01-07-2016
*это класс хранения заявок 
*/

package ru.szhernovoy.dbase;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBManager {

	//private Connection conn = null;
	private final static Logger Log = LoggerFactory.getLogger(DBManager.class);
/*
	public boolean connect()  {
		boolean result = false;
		Properties props = getProperties();
		try {
			conn = DriverManager.getConnection(props.getProperty("url"), props);
			result = true;
		} catch (SQLException e) {
			Log.error(e.getMessage(),e);
		}
		return result;
	}

	public Properties getProperties() {

        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(this.getClass().getResource("DBManager.properties").getPath())) {
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
*/
	public static boolean addUser(User user,final  Connection conn){
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO users(name,email,login,create_date) VALUES (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			st.setString(1,user.getName());
			st.setString(2,user.getEmail());
			st.setString(3,user.getLogin());
			st.setTimestamp(4,new Timestamp(user.getCreateDate()));
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
		return true;
	}

	public static List<User> getUsers(final  Connection conn){

		List<User> result = new ArrayList<>();//new Item[];// позиция всегда указывает на пустой или возможно пустой элемент
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM users");
			rs = st.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getString("email"),rs.getString("name"),rs.getString("login") ,rs.getTimestamp("create_date").getTime());
				result.add(user);
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

	public static void deleteUser(User user,final  Connection conn){
		String email = user.getEmail();
		if(email != null){
			PreparedStatement st = null;
			try {
				st = conn.prepareStatement("DELETE FROM users WHERE email = ?");
				st.setString(1, email);
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
	
	public static void updateItem(User user,final  Connection conn){
		String email = user.getEmail();
		if(email != null){
			PreparedStatement st = null;
			try {
				st = conn.prepareStatement("UPDATE users SET name = ?, email = ? ,login = ?, create_date = ? WHERE email = ?");
				st.setString(1,user.getName());
				st.setString(2,user.getEmail());
				st.setString(3,user.getLogin());
				st.setTimestamp(4,new Timestamp(user.getCreateDate()));
				st.setString(5,user.getEmail());
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
/*
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
*/
}