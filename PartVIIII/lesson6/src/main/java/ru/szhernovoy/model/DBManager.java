/**
*@author Sergey Zhernovoy
*@since 01-07-2016
*это класс хранения заявок 
*/

package ru.szhernovoy.model;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.beans.Statement;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
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

		if(!existRootUser()){
			User rootUser = new User("root@mail.ru","root","root",System.currentTimeMillis(),"root");
			if(!existRootRole()){
				Role rootRole = new Role("root");
				rootRole.setRoot(true);
				addRole(rootRole);
				rootUser.setRole(rootRole);
			}
			addUser(rootUser);
		}
	}

	public boolean existRootUser(){
		boolean exist = false;

		try(Connection conn = this.pool.getConnection();PreparedStatement st = conn.prepareStatement("SELECT * FROM users left join role ON users.role = role.role_id where role.root = TRUE");ResultSet rs = st.executeQuery()) {
			if(rs!= null && rs.next()) {
				exist = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return exist;
	}

	public boolean existRootRole(){

		boolean exist = false;
		try(Connection conn = this.pool.getConnection();PreparedStatement st = conn.prepareStatement("SELECT * FROM role where role.root = TRUE");ResultSet rs = st.executeQuery()) {
			if (rs!=null && rs.next()) {
				exist = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exist;
	}

	public static DBManager instance(){
		return dbManager;
	}

	public boolean addUser(User user){
		try(Connection conn = this.pool.getConnection();PreparedStatement st = 	conn.prepareStatement("INSERT INTO users(name,email,login,create_date,password,role) VALUES (?,?,?,?,?,?)")) {
			st.setString(1,user.getName());
			st.setString(2,user.getEmail());
			st.setString(3,user.getLogin());
			st.setTimestamp(4,new Timestamp(user.getCreateDate()));
			st.setString(5,user.getPassword());
			st.setInt(6,user.getRole().getId());
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean addRole(Role role){
		boolean result = false;
		ResultSet rs = null;
		PreparedStatement st = null;
		try(Connection conn = this.pool.getConnection()) {
			st = 	conn.prepareStatement("INSERT INTO role(name,root) VALUES (?,?)", java.sql.Statement.RETURN_GENERATED_KEYS );
			st.setString(1,role.getName());
			st.setBoolean(2,role.getRoot());
			st.executeUpdate();
			rs = st.getGeneratedKeys();
			if(rs.next()){
				role.setId(rs.getInt("role_id"));
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(st != null){
				try {
					rs.close();
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}


	public List<User> getUsers(){

		List<User> result = new ArrayList<User>();//new Item[];// позиция всегда указывает на пустой или возможно пустой элемент
		ResultSet rs = null;
		try(Connection conn = this.pool.getConnection();PreparedStatement st = conn.prepareStatement("SELECT u.email as email, u.name as name, u.login as login, u.create_date as create, u.password as pass, r.name as rname, r.role_id as roleid, r.root as root  FROM users as u left join role as r on u.role = r.role_id") ) {
			rs = st.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getString("email"),rs.getString("name"),rs.getString("login") ,rs.getTimestamp("create").getTime(),rs.getString("pass"));
				Role role = new Role(rs.getString("rname"));
				role.setId(rs.getInt("roleid"));
				role.setRoot(rs.getBoolean("root"));
				user.setRole(role);
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

	public List<Role> getRoles(){

		List<Role> result = new ArrayList<>();//new Item[];// позиция всегда указывает на пустой или возможно пустой элемент
		ResultSet rs = null;
		try(Connection conn = this.pool.getConnection();PreparedStatement st = conn.prepareStatement("SELECT * FROM role") ) {
			rs = st.executeQuery();
			while (rs.next()) {
				Role role = new Role(rs.getString("name"));
				role.setId(rs.getInt("role_id"));
				role.setRoot(rs.getBoolean("root"));
				result.add(role);
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

	public void deleteRole(Role role){
		String name = role.getName();
		if(name != null) {
			try (Connection conn = this.pool.getConnection(); PreparedStatement st = conn.prepareStatement("DELETE FROM role WHERE role.name = ?")) {
				st.setString(1, name);
				st.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void updateItem(User user){
		String email = user.getEmail();
		if(email != null ){
			try(Connection conn = this.pool.getConnection(); PreparedStatement st =conn.prepareStatement("UPDATE users SET name = ?, email = ? ,login = ?, create_date = ?, role = ? WHERE email = ?") ) {
				st.setString(1,user.getName());
				st.setString(2,user.getEmail());
				st.setString(3,user.getLogin());
				st.setTimestamp(4,new Timestamp(user.getCreateDate()));
				st.setString(6,user.getEmail());
				st.setInt(5,user.getRole().getId());
				st.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void updateRole(Role role){

		try(Connection conn = this.pool.getConnection(); PreparedStatement st =conn.prepareStatement("UPDATE role SET name = ?, root = ? WHERE role_id = ?") ) {
			st.setString(1,role.getName());
			st.setBoolean(2,role.getRoot());
			st.setInt(3,role.getId());
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public User isCredential(String login, String password){
		User findUser = null;
		for(User user : this.getUsers()){
			if(user.getLogin().equals(login) && user.getPassword().equals(password)){
				findUser = user;
				break;
			}
		}
		return  findUser;
	}

}