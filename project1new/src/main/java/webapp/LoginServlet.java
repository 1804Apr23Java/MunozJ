package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setAttribute("name", request.getParameter("name"));
		
		Helper h1 = new Helper();
		System.out.println("name looking for is: "+request.getParameter("name"));
		String retEmail ="retemail";
		try {
			retEmail = h1.grabEmail(request.getParameter("name"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(retEmail);
	//	
		request.setAttribute("email", retEmail);
	//	
		request.getRequestDispatcher("/WEB-INF/views/welcomeHome.jsp").forward(request, response);
	}
}