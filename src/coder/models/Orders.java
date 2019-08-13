package coder.models;

public class Orders {
	
	private int id,users_id;
	private String orders;
	public Orders(int id, int users_id, String orders) {
		super();
		this.id = id;
		this.users_id = users_id;
		this.orders = orders;
	}
	
	public Orders(int users_id, String orders) {
		super();
		this.users_id = users_id;
		this.orders = orders;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUsers_id() {
		return users_id;
	}
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	public String getOrders() {
		return orders;
	}
	public void setOrders(String orders) {
		this.orders = orders;
	}
	
	

}
