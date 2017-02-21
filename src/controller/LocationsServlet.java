package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.MyUtils;
import DAO.LocationDAO;
import beans.Image;
import beans.Location;
import beans.UserAccount;

@WebServlet("/location")
public class LocationsServlet extends HttpServlet {
	private static LocationDAO locationDB = new LocationDAO();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO get userName
		// check login
		HttpSession session = request.getSession();
		UserAccount loginedUser = MyUtils.getLoginedUser(session);
		if (loginedUser == null) {
			// redirect login page
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		String errorString = null;
		List<Location> listLocations = null;
		List<Image> listImage = null;
		// List<Blog> listBlog = null;
		/*
		 * Blog lastNewBlog = new Blog(); ImageDAO imgDB = new ImageDAO();
		 * BlogDAO blogDB = new BlogDAO();
		 */

		listLocations = locationDB.getLocations();
		/*
		 * listBlog = blogDB.getBlog(loginedUser.getUserName()); if
		 * (listBlog.isEmpty() == false) { lastNewBlog = listBlog.get(0); } //
		 * int size = listBlog.size(); if (size > 1) { listBlog =
		 * listBlog.subList(1, size - 1); } listImage = imgDB.getImage(1); for
		 * (Blog image : listBlog) {
		 * System.out.println(image.getPublish_Date()); }
		 */

		// Add request attribute
		request.setAttribute("errorString", errorString);
		// request.setAttribute("listTravel", listTravel);
		request.setAttribute("listLocations", listLocations);
		// request.setAttribute("lastNewBlog", lastNewBlog);
		// request.setAttribute("listImage", listImage);

		// Forward sang /WEB-INF/views/travelListView.jsp
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/locationListView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
