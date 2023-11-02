

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = "kalwarsushil2@gmail.com";
		String password = "12345678";		
		
		
		String emailParams = request.getParameter("email");
		String passwordParams = request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(emailParams == null && passwordParams == null) {
			out.println("<h1>");
			out.println("Field are Missing");
			out.println("</h1>");
		}else {
			if(emailParams.equals(email) && passwordParams.equals(password)) {
				out.println("<h1>");
				out.println("Congratulation!!");
				out.println("</h1>");
			}else {
				out.println("<h1>");
				out.println("Email or Password invalid!!");
				out.println("</h1>");
				out.println("<a href='/college/login.jsp'>");
				out.println("Try again!");
				out.println("</a>");
			}
			
		}
	}

}
