

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Book
 */
@WebServlet("/Book")
public class Book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Book() {
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
		PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        
        String subject = request.getParameter("subject");
        
        out.println("<h1>Books on " + subject + "</h1>");
        out.println("<table border=\"1\">");
        out.println("<tr>");
        out.println("<th>Book Name</th>");
        out.println("<th>Book Author</th>");
        out.println("<th>Book Price</th>");
        out.println("</tr>");

        if (subject.equals("operating_system")) {
            out.println("<tr>");
            out.println("<td>Operating System Concepts</td>");
            out.println("<td>Abraham Silberschatz, Greg Gagne, and Peter B. Galvin</td>");
            out.println("<td>$55</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Operating Systems Three Easy Pieces</td>");
            out.println("<td>Remzi Arpaci-Dusseau and Andrea Arpaci-Dusseau</td>");
            out.println("<td>$25</td>");
            out.println("</tr>");
        } else if (subject.equals("network_security")) {
            out.println("<tr>");
            out.println("<td>Hacking: The Art Of Exploitation</td>");
            out.println("<td>Jon Erickson</td>");
            out.println("<td>$20</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Metasploit: The Penetration Tester’s Guide</td>");
            out.println("<td>David Kennedy, Jim O'Gorman</td>");
            out.println("<td>$43</td>");
            out.println("</tr>");
        } else if (subject.equals("advanced_java")) {
            out.println("<tr>");
            out.println("<td>Head First Java</td>");
            out.println("<td>Kathy Sierra and Bert Bates</td>");
            out.println("<td>$38.50</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Java: A Beginners Guide</td>");
            out.println("<td>Herbert Schildt</td>");
            out.println("<td>$35.68</td>");
            out.println("</tr>");
        } else if (subject.equals("data_mining")) {
            out.println("<tr>");
            out.println("<td>An Introduction to Statistical Learning</td>");
            out.println("<td>Gareth James and Daniela Witten</td>");
            out.println("<td>$101.20</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Principles and Theory for Data Mining and Machine Learning</td>");
            out.println("<td>Bertrand Clarke and Ernest Fokoue</td>");
            out.println("<td>$120.42</td>");
            out.println("</tr>");
        } else {
            out.println("<tr>");
            out.println("<td colspan=\"3\">Invalid subject</td>");
            out.println("</tr>");
        }

        out.println("</table>");
	}
}
