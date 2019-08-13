package coder.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coder.models.Products;

public class ProductDAO {
	
	public List<Products> getAllProducts(Connection con, int cat_id){
		List<Products> products = new ArrayList<Products>();
		
		String query = "SELECT * FROM products WHERE cat_id = ?";
		PreparedStatement stmt = null;
		ResultSet set = null;
		try {
			stmt = con.prepareStatement(query);
			stmt.setInt(1, cat_id);
			set = stmt.executeQuery();
			
			while(set.next()) {
				products.add(new Products(
						
						set.getInt("id"),set.getInt("cat_id"),set.getInt("price"),set.getString("name"),
						set.getString("image")
						));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(set != null) {
			try {
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return products;
	}

	
	
	public Products getSingleProduct(Connection con, int id) {
		
		Products products = null;
		
		String query = "SELECT * FROM products WHERE id=?";
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		try {
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			set = stmt.executeQuery();
			while(set.next()) {
		
				products = new Products(
						
						set.getInt("id"),
						set.getInt("cat_id"),
						set.getInt("price"),
						set.getString("name"),
						set.getString("image")
						
						);}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(set != null) {
			try {
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return products;
	}



}
