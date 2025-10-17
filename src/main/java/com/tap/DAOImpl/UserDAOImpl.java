package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.UserDAO;
import com.tap.models.User;
import com.tap.util.DBconnection;

public class UserDAOImpl implements UserDAO{

	int res=0;
	private String INSERT = "INSERT into `user` (`name`,`Username`,`Password`,`Email`,`Phone`,`Address`,`Role`,`CreateDate`,`LastLoginDate`) values(?,?,?,?,?,?,?,?,?)";
	private String GET_USER = "SELECT * FROM `user` WHERE `UserID` = ?";
	private String DELETE_USER = "DELETE FROM `user` WHERE `UserID` = ?";
	private String GET_ALL_USER = "SELECT * FROM `user`";
	private String UPDATE_USER = "UPDATE user SET name=?,username=?,password=?,email=?,phone=?,address=?,role=? WHERE userID=?";
	
	Connection con = DBconnection.getConnection();
	
	@Override
	public void addUser(User user) {
		try {
				//Connection con = DBconnection.getConnection();
			PreparedStatement pstmt= con.prepareStatement(INSERT);
			//pstmt.setInt(1, user.getUserdID());
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPhone());
			pstmt.setString(6, user.getAddress());
			pstmt.setString(7, user.getRole());
			pstmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			
			int res = pstmt.executeUpdate();
			
			System.out.println(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int updateUser(User user) {
		int res = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(UPDATE_USER);
			pstmt.setInt(1, user.getUserdID());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getPhone());
			pstmt.setString(7, user.getAddress());
			pstmt.setString(8, user.getRole());
			
			res = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int deleteUser(int id) {
		int res=0;
		try {
			PreparedStatement pstmt = con.prepareStatement(DELETE_USER);
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public User getUser(int id) {
		//Connection con = DBconnection.getConnection();
		User user = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(GET_USER);
			pstmt.setInt(1, id);
			
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				int userID = res.getInt("userID");
				String name= res.getString("name");
				String username= res.getString("username");
				String password = res.getString("password");
				String email = res.getString("email");
				String phone = res.getString("phone");
				String address = res.getString("address");
				String role = res.getString("role");
				Timestamp createDate = res.getTimestamp("createDate");
				Timestamp lastLoginDate = res.getTimestamp("lastLoginDate");
				
				user = new User(userID,name,username,password,email,phone,address,role,createDate,lastLoginDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		User user = null;
		
		ArrayList<User>list = new ArrayList<User>();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(GET_ALL_USER);
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				int userID = res.getInt("userID");
				String name= res.getString("name");
				String username= res.getString("username");
				String password = res.getString("password");
				String email = res.getString("email");
				String phone = res.getString("phone");
				String address = res.getString("address");
				String role = res.getString("role");
				Timestamp createDate = res.getTimestamp("createDate");
				Timestamp lastLoginDate = res.getTimestamp("lastLoginDate");
				
				user = new User(userID,name,username,password,email,phone,address,role,createDate,lastLoginDate);
				
				list.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
