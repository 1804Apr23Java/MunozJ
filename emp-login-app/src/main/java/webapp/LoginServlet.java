package webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.tables.User;
import webapp.Dao.*;
import webapp.helper.GetInfo;


@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setAttribute("name", req.getParameter("name"));
		req.setAttribute("password", req.getParameter("password"));
		
		/*trying to use DAOs*/
//		String testEmail = null;
//		testEmail=getEmailbyName("JOSE");
//		GetInfo newinfo = new GetInfo();
//		System.out.println(newinfo.grabEmail("JOSE"));
		
		req.getRequestDispatcher("/WEB-INF/views/empHome.jsp").forward(req, resp);

	}

}