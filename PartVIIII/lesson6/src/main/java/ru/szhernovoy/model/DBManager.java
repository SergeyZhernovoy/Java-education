/**
*@author Sergey Zhernovoy
*@since 01-07-2016
*это класс хранения заявок 
*/

package ru.szhernovoy.model;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class DBManager {

	private static  final DBManager dbManager = new DBManager();
	private ComboPooledDataSource pool;

	private DBManager(){
		Properties prop = new Properties();
		this.pool = new ComboPooledDataSource();
		try {
			prop.load(new FileInputStream(this.getClass().getClassLoader().getResource("db.properties").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			pool.setDriverClass(prop.getProperty("driverClass"));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		pool.setJdbcUrl(prop.getProperty("jdbcUrl"));
		pool.setUser(prop.getProperty("user"));
		pool.setPassword(prop.getProperty("password"));
		pool.setMaxPoolSize(5);
	}

	public static DBManager instance(){
		return dbManager;
	}

	public boolean addUser(User user){
		try(Connection conn = this.pool.getConnection();PreparedStatement st = 	conn.prepareStatement("INSERT INTO users(name,email,login,create_date) VALUES (?,?,?,?)")) {
			st.setString(1,user.getName());
			st.setString(2,user.getEmail());
			st.setString(3,user.getLogin());
			st.setTimestamp(4,new Timestamp(user.getCreateDate()));
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public List<User> getUsers(){

		List<User> result = new ArrayList<User>();//new Item[];// позиция всегда указывает на пустой или возможно пустой элемент
		ResultSet rs = null;
		try(Connection conn = this.pool.getConnection();PreparedStatement st = conn.prepareStatement("SELECT * FROM users") ) {
			rs = st.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getString("email"),rs.getString("name"),rs.getString("login") ,rs.getTimestamp("create_date").getTime(),rs.getString("password"));
				result.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try{
				rs.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}

		return result;
	}

	public void deleteUser(User user){
		String email = user.getEmail();
		if(email != null) {
			try (Connection conn = this.pool.getConnection(); PreparedStatement st = conn.prepareStatement("DELETE FROM users WHERE email = ?")) {
				st.setString(1, email);
				st.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void updateItem(User user){
		String email = user.getEmail();
		if(email != null ){
			try(Connection conn = this.pool.getConnection(); PreparedStatement st =conn.prepareStatement("UPDATE users SET name = ?, email = ? ,login = ?, create_date = ? WHERE email = ?") ) {
				st.setString(1,user.getName());
				st.setString(2,user.getEmail());
				st.setString(3,user.getLogin());
				st.setTimestamp(4,new Timestamp(user.getCreateDate()));
				st.setString(5,user.getEmail());
				st.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isCredential(String login, String password){
		boolean exist = false;
		for(User user : this.getUsers()){
			if(user.getLogin().equals(login) && user.getPassword().equals(password)){
				exist = true;
				break;
			}
		}
		return  exist;
	}

}