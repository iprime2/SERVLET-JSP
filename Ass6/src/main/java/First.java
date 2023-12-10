
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class First
 */
@WebServlet("/First")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public First() {
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
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		  String username=request.getParameter("username");
	        String add=request.getParameter("add");
	        String age=request.getParameter("age");
	        Cookie c1 = new Cookie("username", username);
	        Cookie c2=new Cookie("add",add);
	        Cookie c3=new Cookie("age",age);

	        response.addCookie(c1);
	        response.addCookie(c2);
	        response.addCookie(c3); 
	        out.println("<body>");
	        out.println("<form action='Second'>");
	        out.println("Enter your Experience:");
	        out.println("<input type='text' name='exp'>");
	        out.println("<br>");
	        out.println("Enter your skills:");
	        out.println("<input type='text' name='skills'>");
	        out.println("<br>");
	        out.println("<input type='submit' name='Continue'>");
	        out.println("</form>");
	        out.println("</body>");
	
	        String exp=request.getParameter("exp");
	        String skills=request.getParameter("skills");
	        Cookie c4 = new Cookie("exp", exp);
	        Cookie c5=new Cookie("skills",skills);
	       response.addCookie(c4);
	       response.addCookie(c5);
	}

}
