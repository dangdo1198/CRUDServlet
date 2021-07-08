package com.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

	public  List<User> getAllUser(){
		
		Connection con;
		PreparedStatement preparedStatement;
		ResultSet rs;
		
		List<User>  listUser = new ArrayList<User>();
		
		try {
			
			con = Connect.openConnection();
			preparedStatement = con.prepareStatement("select * from MyGuests ");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				listUser.add(user);
			}
			// ket ns
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listUser;
		
		
	}
	
	
	public boolean addUser(User user) {
		
		Connection con;
		PreparedStatement preparedStatement;
		ResultSet rs;

		boolean check= false;
		try {
			con = Connect.openConnection();
			preparedStatement= con.prepareCall("INSERT INTO MyGuests (firstname,lastname,email) VALUES (?,?,?)");
				
	
			preparedStatement.setString(1, user.getFirstname());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setString(3, user.getEmail());
			
			
			int a=  preparedStatement.executeUpdate();
			
			
			if(a >0) {
				check = true;
				System.out.println("insert thanh cong: " + user.getFirstname());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			check = false;
		
		}
		
		
		return check;
	}
	
	
	public boolean deleteUser(int id) {
		Connection con = null;
		PreparedStatement callableStatement = null;
		ResultSet rs= null;
		boolean check = false;
		try {
			con = Connect.openConnection();
			callableStatement= con.prepareCall("DELETE FROM MyGuests WHERE id=?");
			callableStatement.setInt(1, id);
			 int a = callableStatement.executeUpdate();
			if(a >0) {
				
				check = true;
				System.out.println( "delete thanh cong " + id);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	
	
	public boolean updateUser(User User) {
		boolean check= false;
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = Connect.openConnection();
			preparedStatement = con.prepareStatement("UPDATE MyGuests  SET firstname =?, lastname = ?,email =? WHERE id=?");
	
			preparedStatement.setString(1, User.getFirstname());
			preparedStatement.setString(2, User.getLastname());
			preparedStatement.setString(3, User.getEmail());
			preparedStatement.setInt(4, User.getId());
			int a = preparedStatement.executeUpdate();
			if( a >0) {
				check = true;
				System.out.println("up date thanh cong "+ User.getId());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
		
	}
	
	
	public  User getUserById(int id){
		
		Connection con;
		PreparedStatement preparedStatement;
		ResultSet rs;
		
		User  user = new User();
		try {
			
			con = Connect.openConnection();
			preparedStatement = con.prepareStatement("select * from MyGuests where id=?");
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				
				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
		
	
		
	}
	
	
	
	public static void main(String[] args) {
		
		UserDao userDao = new UserDao();
	
	

		User user = userDao.getUserById(18);
	
	System.out.println(user.getFirstname() +"  " +user.getEmail());
	  
	
	}
	
}
