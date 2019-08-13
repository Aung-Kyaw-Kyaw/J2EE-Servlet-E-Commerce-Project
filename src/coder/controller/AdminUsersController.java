package coder.controller;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import coder.daos.OrdersDAO;
import coder.models.Orders;


@WebServlet("/AdminUsersController")
public class AdminUsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource ds;
    
    public AdminUsersController() {
        super();
    }
    
    @Override
	public void init(ServletConfig config) throws ServletException {
		try {
			InitialContext initContext = new InitialContext();
			Context env = (Context) initContext.lookup("java:comp/env");
			ds = (DataSource) env.lookup("jdbc/TestDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		PrintWriter pw = response.getWriter();
		Connection con = null;

		
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(action != null) {
			if(action.contentEquals("orderdetail")) {
				showUserOrderDetail(request,response,pw,con);
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
	private void showUserOrderDetail(HttpServletRequest request, HttpServletResponse response,PrintWriter pw,Connection con ) 
			throws ServletException, IOException{
		
		String user_id = request.getParameter("user_id");
		OrdersDAO oDAO = new OrdersDAO();
		java.util.List<Orders> orders  = oDAO.getOrderOfAUser(con, Integer.parseInt(user_id));
		request.setAttribute("orders",orders);
		request.getRequestDispatcher("/order_details.jsp").forward(request, response);
		pw.write(user_id);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
