package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DBUtils;
import utils.MyUtils;
import beans.Location;

@WebServlet(urlPatterns={"/home"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/homeView.jsp");
		Connection conn = MyUtils.getStoredConnection(request);
		String errorString = null;
		List<Location> listTravel = null;
		
			try {
				listTravel = DBUtils.queryTravel(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		// Add request attribute before forward to views
		 request.setAttribute("errorString", errorString);
	     request.setAttribute("listTravel", listTravel);
	       String name ="";
	       for (Location location : listTravel) {
			name = location.getName();
		}
	       request.setAttribute("name", name);

	       dispatcher.forward(request, response);
	       
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
