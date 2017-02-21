package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.DBUtils;
import utils.MyUtils;
import DAO.BlogDAO;
import DAO.ImageDAO;
import beans.Blog;
import beans.Image;
import beans.Location;
import beans.UserAccount;

/**
 * Servlet implementation class TravelServlet
 */
@WebServlet(urlPatterns = { "/travelBlog" })
public class TravelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TravelServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings({ "null", "deprecation" })
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO get userName
		// check login
		HttpSession session = request.getSession();
		UserAccount loginedUser = MyUtils.getLoginedUser(session);
		if (loginedUser == null) {
			// redirect login page
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		Connection conn = MyUtils.getStoredConnection(request);
		String errorString = null;
		List<Location> listTravel = null;
		List<Image> listImage = null;
		List<Blog> listBlog = null;
		Blog lastNewBlog = new Blog();
		ImageDAO imgDB = new ImageDAO();
		BlogDAO blogDB = new BlogDAO();

		try {
			listTravel = DBUtils.queryTravel(conn);
			listBlog = blogDB.getBlog(loginedUser.getUserName());
			if(listBlog.isEmpty()==false)
			{
				lastNewBlog = listBlog.get(0);				
			}
			//
			int size = listBlog.size();
			if(size>1){
				listBlog = listBlog.subList(1, size-1);
			}
			listImage = imgDB.getImage(1);
			for (Blog image : listBlog) {
				System.out.println(image.getPublish_Date());
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			errorString = e.getMessage();
		}
		// Add request attribute before forward to views
		request.setAttribute("errorString", errorString);
		request.setAttribute("listTravel", listTravel);
		request.setAttribute("listBlog", listBlog);
		request.setAttribute("lastNewBlog", lastNewBlog);
		request.setAttribute("listImage", listImage);

		// Forward sang /WEB-INF/views/travelListView.jsp
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/travelListView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
