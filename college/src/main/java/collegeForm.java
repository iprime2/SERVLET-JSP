

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class collegeForm
 */
@WebServlet(name = "/collegeForm", urlPatterns = "/collegeForm")
public class collegeForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public collegeForm() {
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
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        String newStudent = request.getParameter("newStudent");
        String college = request.getParameter("college");
        String major = request.getParameter("major");
        String favcolor = request.getParameter("favcolor");
        String terms = request.getParameter("terms");

        if (email == null || email.isEmpty()
                || password == null || password.isEmpty()
                || birthday == null || birthday.isEmpty()
                || newStudent == null || newStudent.isEmpty()
                || college == null || college.isEmpty()
                || major == null || major.isEmpty()
                || favcolor == null || favcolor.isEmpty()
                || terms == null || terms.isEmpty()) {
         
            out.println("<h1>Error</h1>");
            out.println("<p>One or more fields are empty.</p>");
          
            return;
        }
        
        
        out.println("<body bgcolor= "+ favcolor + ">");
        
        out.println("<h1>Submitted Data</h1>");

        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<th>Field</th>");
        out.println("<th>Value</th>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Email</td>");
        out.println("<td>" + email + "</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Password</td>");
        out.println("<td>" + password + "</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Birthday</td>");
        out.println("<td>" + birthday + "</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>New Student</td>");
        out.println("<td>" + newStudent + "</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>College</td>");
        out.println("<td>" + college + "</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Major</td>");
        out.println("<td>" + major + "</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Favorite Color</td>");
        out.println("<td>" + favcolor + "</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Terms and Conditions</td>");
        out.println("<td>" + terms + "</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");

   
	}

}
