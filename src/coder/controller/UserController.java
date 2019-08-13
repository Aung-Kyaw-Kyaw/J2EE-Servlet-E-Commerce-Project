package coder.controller;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import coder.daos.UsersDAO;
import coder.models.Users;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource ds;

	public UserController() {
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		Connection con = null;
		UsersDAO usersDAO = new UsersDAO();

		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (action == null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else {
			switch (action) {
			case "billout":
				if (session.getAttribute("users") == null) {
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/cartout.jsp").forward(request, response);
				}

			case "login":
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				break;

			case "register":
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				break;

			case "loginform":

				String email = request.getParameter("email");
				String password = request.getParameter("password");

				Users users = usersDAO.getUserByEmail(con, email);

				if (users == null || !password.contentEquals(users.getPassword())) {
					request.setAttribute("msgError", "Login Error! Please try again.");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				} else if (users.getId() == 1 && users.getRole() == 1) {

					session.setAttribute("users", users);
					request.setAttribute("msgSuccess", "Welcome Back!");
					request.getRequestDispatcher("/admin.jsp").forward(request, response);
				}

				else {
					session.setAttribute("users", users);
					request.setAttribute("msgSuccess", "Welcome Back!");
					request.getRequestDispatcher("/cartout.jsp").forward(request, response);
				}

				break;

			case "logout":
				session.removeAttribute("users");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				break;

			case "registerForm":
				registerAUser(request, response, con, usersDAO);
				break;
			}
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void registerAUser(HttpServletRequest request, HttpServletResponse response, Connection con,
			UsersDAO usersDAO) throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Users users = usersDAO.getUserByEmail(con, email);

		if (users == null) {

			boolean bol = usersDAO.registerAUser(con, name, email, password, 3);

			if (bol) {
				request.setAttribute("msgSuccess", "Register Success, Please login below.");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else {
				request.setAttribute("msgError", "Something wrong ,Please contact admin!");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}

		} else {
			request.setAttribute("msgError", "Email is alread in use!");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
