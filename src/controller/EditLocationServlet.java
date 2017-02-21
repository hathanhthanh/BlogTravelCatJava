package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.MyUtils;
import DAO.LocationDAO;
import beans.Location;

@WebServlet("/editLocation")
public class EditLocationServlet extends HttpServlet {

	private static LocationDAO locationDB = new LocationDAO();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);
		int Local_ID = Integer.parseInt(request.getParameter("local_ID"));
		Location location = null;
		String errorString = null;
		try {
			location = locationDB.findLocation(conn, Local_ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorString = e.getMessage();
		}
		// this location is not exist
		if(errorString!=null && location == null){
			response.sendRedirect(request.getServletPath() + "/location");
			return;
		}
		//
		request.setAttribute("errorString", errorString);
		request.setAttribute("location", location);
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/editLocationView.jsp");
		dispatcher.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);
		int local_ID =Integer.parseInt( request.getParameter("local_ID"));
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String address = request.getParameter("address");
		String station = request.getParameter("station");	
		//
		Date last_Edit = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		Location location = new Location();
		location.setLocal_ID(local_ID);
		location.setName(name);
		location.setContent(content);
		location.setAddress(address);
		location.setStation(station);
		location.setLast_Edit(last_Edit);
		
		String errorString = null;
		try {
			locationDB.updateLocaltion(conn, location);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorString = e.getMessage();
		}
		// save information to request attribute before forward to views
		request.setAttribute("errorString", errorString);
		request.setAttribute("location", location);
		
		// error problem => forward edit view
		if(errorString!= null){
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/editLocationView.jsp");
			dispatcher.forward(request, response);
		}
		else{
			response.sendRedirect(request.getContextPath() + "/location");
		}
		
	}


}
