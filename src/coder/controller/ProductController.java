package coder.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

import coder.daos.ProductDAO;
import coder.models.Products;


@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource ds;   
   
    public ProductController() {
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
	
		PrintWriter pw = response.getWriter();

		List<Products> products = null;
		ProductDAO proDAO = new ProductDAO();
	    String cat_id = request.getParameter("cat_id");
		
		Connection con = null;
		try {
			con = ds.getConnection();
			products = proDAO.getAllProducts(con, Integer.parseInt(cat_id));
		} catch (SQLException e) {
			pw.write("DB Connection E rror");
		}

		
		if(cat_id == null) {
			cat_id = "1";
		}
			
		request.setAttribute("products", products);
		request.getRequestDispatcher("/products.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
