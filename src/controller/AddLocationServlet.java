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

@WebServlet("/addLocation")
public class AddLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static LocationDAO locationDB = new LocationDAO();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/addLocationView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);
		String errorString = null;
		String name = (String) request.getParameter("name");
		String content = (String) request.getParameter("content");
		String address = (String) request.getParameter("address");
		String station = (String) request.getParameter("station");
		//
		int parent_ID = 0;
		Date publish_Date = new java.sql.Date(Calendar.getInstance().getTime()
				.getTime());
		Date last_Edit = new java.sql.Date(Calendar.getInstance().getTime()
				.getTime());
		System.out.println(publish_Date);
		int status = 0;
		Location local = new Location();
		local.setParent_ID(parent_ID);
		local.setName(name);
		local.setContent(content);
		local.setAddress(address);
		local.setStation(station);
		local.setPublish_Date(publish_Date);
		local.setLast_Edit(last_Edit);
		local.setStatus(status);
		// insert in to locations table
		try {
			locationDB.insertLocation(conn, local);
		} catch (SQLException e) {

			e.printStackTrace();
			errorString = e.getMessage();
		}
		// save information before forward to views
		request.setAttribute("errorString", errorString);
		request.setAttribute("local", local);

		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/addLocation.jsp");
			dispatcher.forward(request, response);
		}
		response.sendRedirect(request.getContextPath() + "/Location");
	}
}
