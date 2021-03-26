package logout;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		try {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			if(username.equals("admin") && password.equals("admin")){
				//Success
				
				//Save user in session.
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(300);
				session.setAttribute("activeUser", username);
				session.setAttribute("projectName", "Java Servlet Web!");
				pw.print("Welcome! " + "<a href = 'LogoutServlet'>Logout</a>");
					
			}else{
				//Error
				
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				pw.println("<h2 style='color:red'>Sorry! Login Error.</h2>");
				rd.include(request, response);
			}
		}
		 catch (Exception e) {
			// TODO: handle exception
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
