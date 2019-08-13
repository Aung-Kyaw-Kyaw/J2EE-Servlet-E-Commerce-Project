package coder.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coder.models.Orders;


public class OrdersDAO {

	public boolean insertNewOrder(Connection con,int users_id,String orders) {
		
		boolean bol = false;
		
		String query = "INSERT INTO orders (users_id,orders) VAlUES (?,?)";
		
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(query);
			stmt.setInt(1, users_id);
			stmt.setString(2, orders);
			
			int result = stmt.executeUpdate();
			if(result == 1) {
				bol = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return bol;
	}

	public List<Orders> getOrderOfAUser(Connection con, int user_id){
		List<Orders> orders = new ArrayList<>();
		
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		String query = "SELECT * FROM orders WHERE user_id=?";
		
		try {
			stmt = con.prepareStatement(query);
			stmt.setInt(1, user_id);
			set = stmt.executeQuery();
			
			while (set.next()) {
				orders.add(new Orders(
						
						set.getInt("id"),
						set.getInt("user_id"),
						set.getString("orders")
						
						));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(set != null) {
			try {
				set.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return orders;
	}
}
