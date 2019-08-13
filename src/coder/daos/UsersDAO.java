package coder.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import coder.models.Users;

public class UsersDAO {

	public Users getUserByEmail(Connection con, String email) {
		
		Users users = null;
		
		String query = "SELECT * FROM users WHERE email=?";
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(1, email);
			set = stmt.executeQuery();
			
			while(set.next()) {
				users = new Users(
						
						set.getInt("id"),
						set.getInt("role"),
						set.getString("name"),
						set.getString("email"),
						set.getString("password")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
		try {
			set.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	public boolean registerAUser(Connection con,String name,String email,String password,int role) {
		boolean bol = false;
		
		
		String query = "INSERT INTO users (name,email,password,role) VALUES (?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2,email);
			stmt.setString(3, password);
			stmt.setInt(4, role);
			
			int result = stmt.executeUpdate();
			
			if(result == 1) {
				bol = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return bol;
	}
}
