package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.UserDao;
import daos.UserDaoImp;
import daos.UserModel;




@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		//request.getRequestDispatcher("login.html").forward(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		/*my old working code
		request.setAttribute("name", request.getParameter("name"));
		
		Helper h1 = new Helper();
		System.out.println("name looking for is: "+request.getParameter("name"));
		String retEmail ="retemail";
		try {
			retEmail = h1.grabEmail(request.getParameter("name"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(retEmail);
		request.setAttribute("email", retEmail);
		request.getRequestDispatcher("/WEB-INF/views/welcomeHome.jsp").forward(request, response);
	}
}*/
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		Helper h1 = new Helper();
		UserDao um = new UserDaoImp();

		String username = request.getParameter("name");
		System.out.println("Username =" +username);
		String password = request.getParameter("password");
		System.out.println("Password =" +password);
		System.out.println(um.getUserModel(username).toString());
		//authenticate user
		if(password.equals("pass")) {
			String retEmail ="retemail";
			try {
				retEmail = h1.grabEmail(request.getParameter("name"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println(retEmail);
			System.out.println("accepted pass");
			request.setAttribute("email", retEmail);
			session.setAttribute("email", retEmail);
			session.setAttribute("username", username);
			session.setAttribute("problem", null);
			response.sendRedirect("welcomeHome.jsp");

		} else {

			session.setAttribute("problem", "incorrect password");
			response.sendRedirect("login.do");
		}
		
	}

}