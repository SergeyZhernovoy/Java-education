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

	private final static Logger Log = LoggerFactory.getLogger(DBManager.class);
	private static  final DBManager dbManager = new DBManager();

	private DBManager(){
	}

	public static DBManager instance(){
		return dbManager;
	}


	public boolean addUser(User user,final  Connection conn){
		PreparedStatement st = null;
		if(conn != null){
			try {
				st = conn.prepareStatement("INSERT INTO users(name,email,login,create_date) VALUES (?,?,?,?)");
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
					conn.close();
				}
				catch (Exception e){
					Log.error(e.getMessage(),e);
				}
			}
		}

		return true;
	}

	public List<User> getUsers(final  Connection conn){

		List<User> result = new ArrayList<>();//new Item[];// позиция всегда указывает на пустой или возможно пустой элемент
		PreparedStatement st = null;
		ResultSet rs = null;
		if(conn!=null){
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
					conn.close();
				}
				catch (Exception e){
					Log.error(e.getMessage(),e);
				}
			}
		}

		return result;
	}

	public void deleteUser(User user,final  Connection conn){
		String email = user.getEmail();
		if(email != null && conn != null){
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
					conn.close();
				}
				catch (Exception e){
					Log.error(e.getMessage(),e);
				}
			}
		}
	}
	
	public void updateItem(User user,final  Connection conn){
		String email = user.getEmail();
		if(email != null && conn != null){
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
					conn.close();
				}
				catch (Exception e){
					Log.error(e.getMessage(),e);
				}
			}
		}

	}

}