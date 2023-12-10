

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Second
 */
@WebServlet("/Second")
public class Second extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Second() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String exp=request.getParameter("exp");
        String skills=request.getParameter("skills");
        Cookie c4 = new Cookie("exp", exp);
        Cookie c5=new Cookie("skills",skills);
       response.addCookie(c4);
       response.addCookie(c5);
		
		out.println("<body>");
		out.println("<form action='Third'>");
		out.println("Enter your expected Salary : ");
		out.println("<br>");
		out.println("<input type='text' name='sal'>");
		out.println("<br>");
		out.println("Enter your expected location : ");
		out.println("<br>");
		out.println("<input type='text' name='loc'>");
		out.println("<br>");
		out.println("<input type='submit' name='Continue'>");
        out.println("</form>");
        out.println("</body>");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
