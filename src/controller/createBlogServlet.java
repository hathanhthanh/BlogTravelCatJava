package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.MyUtils;
import DAO.BlogDAO;
import DAO.LocationDAO;
import beans.Blog;
import beans.Location;
import beans.UserAccount;

@WebServlet(urlPatterns = { "/createBlog" })
public class createBlogServlet extends HttpServlet {
	private static BlogDAO blogDB = new BlogDAO();
	private static LocationDAO locationDB = new LocationDAO();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserAccount loginedUser = MyUtils.getLoginedUser(session);
		if (loginedUser == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		List<Location> listLocations = new ArrayList<Location>();
		listLocations = locationDB.getLocations();
		// set attributes
		request.setAttribute("listLocations", listLocations);
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/createBlogView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UserAccount loginedUser = MyUtils.getLoginedUser(session);
		/*if (loginedUser == null) {
			// redirect login page
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}*/
		String errorString = null;
		int local_ID = Integer.parseInt(request.getParameter("local_ID"));
		System.out.println(request.getParameter("local_ID"));
		String contents = (String) request.getParameter("contents");
		String image_Name = (String) request.getParameter("image_Name");
		String title = (String) request.getParameter("title");
		//
		Date publish_Date = new java.sql.Date(Calendar.getInstance().getTime()
				.getTime());
		Date last_Edit = new java.sql.Date(Calendar.getInstance().getTime()
				.getTime());
		System.out.println(publish_Date);
		int status = 0;
		Blog blog = new Blog();
		blog.setTitle(title);
		blog.setLocal_ID(local_ID);
		blog.setContents(contents);
		blog.setUserName(loginedUser.getUserName());
		blog.setPublish_Date(publish_Date);
		blog.setLast_Edit(last_Edit);
		blog.setStatus(status);
		// insert in to locations table
		if (blogDB.insertBlog(blog) != true) {
			// save information before forward to views
				
			request.setAttribute("errorString", errorString);
			request.setAttribute("blog", blog);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/createBlogView.jsp");
			dispatcher.forward(request, response);
		}
		
		response.sendRedirect(request.getContextPath() + "/travelBlog");
	}

}
