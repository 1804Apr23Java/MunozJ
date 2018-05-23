package webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/session")
public class SessionServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4641489159640659305L;
	 public SessionServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(false);
			if(session!=null) {
				response.setContentType("application/json");
				response.getWriter().write("{\"username\":\""+session.getAttribute("username")+"\"}");
			} else {
				response.setContentType("application/json");
				response.getWriter().write("{\"username\":null}");
			}
		}


	}