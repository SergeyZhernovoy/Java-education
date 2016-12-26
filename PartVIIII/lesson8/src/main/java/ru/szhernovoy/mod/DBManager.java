/**
*@author Sergey Zhernovoy
*@since 01-07-2016
*это класс хранения заявок 
*/

package ru.szhernovoy.mod;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DBManager {

	private static DBManager dbManager = new DBManager();

	private DBManager(){

	}

	public static class SingletonHolder {
		public static final DBManager HOLDER_INSTANCE = new DBManager();
	}

	public static DBManager newInstance(){
		return SingletonHolder.HOLDER_INSTANCE;
	}

	public  void matcherRoot() {
		if (!existRootUser()) {
			User rootUser = new User("root@mail.ru", "root", System.currentTimeMillis(), "root");
			rootUser.setCountry_id(1);
			rootUser.setCity_id(1);
			addUser(rootUser);
		}
	}

	public  boolean existRootUser(){
		boolean exist = false;

		try(Connection conn = PoolConnectors.getConnection(); PreparedStatement st = conn.prepareStatement("SELECT * FROM users where users.login LIKE 'root'"); ResultSet rs = st.executeQuery()) {
			if(rs!= null && rs.next()) {
				exist = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return exist;
	}

	public boolean addUser(User user){
		try(Connection conn = PoolConnectors.getConnection();PreparedStatement st = 	conn.prepareStatement("INSERT INTO users(email,login,create_date,password,country,city) VALUES (?,?,?,?,?,?)")) {
			st.setString(1,user.getEmail());
			st.setString(2,user.getLogin());
			st.setTimestamp(3,new Timestamp(user.getCreateDate().getTime()));
			st.setString(4,user.getPassword());
			st.setInt(5,user.getCountry_id());
			st.setInt(6,user.getCity_id());
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean addCountry(String country){
		boolean result = false;
		try(Connection conn = PoolConnectors.getConnection();PreparedStatement st = conn.prepareStatement("INSERT INTO country(name) VALUES (?)") ) {
			st.setString(1,country);
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean addCity(String city){
		boolean result = false;
		try(Connection conn = PoolConnectors.getConnection();PreparedStatement st = conn.prepareStatement("INSERT INTO city(name) VALUES (?)") ) {
			st.setString(1,city);
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public List<User> getUsers(){

		List<User> result = new ArrayList<User>();//new Item[];// позиция всегда указывает на пустой или возможно пустой элемент
		ResultSet rs = null;
		try(Connection conn = PoolConnectors.getConnection();PreparedStatement st = conn.prepareStatement("SELECT u.email, u.login, u.create_date as create, u.password as pass, c.name as cname, u.city as cid, ctr.name as ctrname, u.country as ctrid  FROM users as u left join city as c on u.city = c.id left join country as ctr on u.country = ctr.id") ) {
			rs = st.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getString("email"),rs.getString("login") ,rs.getTimestamp("create").getTime(),rs.getString("pass"));
				user.setCity_id(Integer.valueOf(rs.getString("cid")));
				user.setNameCity(rs.getString("cname"));
				user.setCountry_id(Integer.valueOf(rs.getString("ctrid")));
				user.setNameCountry(rs.getString("ctrname"));
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

	public Map<Integer,String> getCityOrCountry(int type){
		Map<Integer,String> result = new HashMap<>();//new Item[];// позиция всегда указывает на пустой или возможно пустой элемент
		try(Connection conn = PoolConnectors.getConnection();PreparedStatement st = conn.prepareStatement(String.format("SELECT obj.name, obj.id FROM %s AS obj ORDER BY id",type == 1 ? "country" : "city"));ResultSet rs = st.executeQuery() ) {
		    while (rs.next()) {
				result.put(rs.getInt("id"),rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void deleteUser(User user){
		String login = user.getLogin();
		if(login != null) {
			try (Connection conn = PoolConnectors.getConnection(); PreparedStatement st = conn.prepareStatement("DELETE FROM users WHERE login = ?")) {
				st.setString(1, login);
				st.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void updateItem(User user){
		String email = user.getEmail();
		if(email != null ){
			try(Connection conn = PoolConnectors.getConnection(); PreparedStatement st =conn.prepareStatement("UPDATE users SET email = ? ,login = ?, password = ?, city = ?, country = ? WHERE login = ?") ) {
				st.setString(1,user.getEmail());
				st.setString(2,user.getLogin());
				st.setString(3,user.getPassword());
				st.setInt(4,user.getCity_id());
				st.setInt(5,user.getCountry_id());
				st.setString(6,user.getLogin());
				st.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public User isCredential(String login, String password){
		User findUser = null;
		for(User user : getUsers()){
			if(user.getLogin().equals(login) && user.getPassword().equals(password)){
				findUser = user;
				break;
			}
		}
		return  findUser;
	}

}