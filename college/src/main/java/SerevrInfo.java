

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SerevrInfo
 */
@WebServlet("/SerevrInfo")
public class SerevrInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerevrInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>" + "Server Information" + "</h1>");
		out.println("<table style='width:80%;border: 1px solid black;border-radius: 10px;'>");
		
		out.println("<tr>");
		
		out.println("<th style='width:40%;border: 1px solid black;'>");
		out.println("Parameter");
		out.println("</th>");
		
		out.println("<th style='width:60%;border: 1px solid black;'>");
		out.println("Values");
		out.println("</th>");
		
		out.println("</tr>");
		
		out.println("<tr>");
		
		out.println("<td style='border: 1px solid black;'>");
		out.println("Server Name");
		out.println("</td>");
		
		out.println("<td style='border: 1px solid black;'>");
		out.println(request.getServerName());
		out.println("</td>");
		
		out.println("</tr>");
		
		out.println("<tr>");
		
		out.println("<td style='border: 1px solid black;'>");
		out.println("Server Port");
		out.println("</td>");
		
		out.println("<td style='border: 1px solid black;'>");
		out.println(request.getServerPort());
		out.println("</td>");
		
		out.println("</tr>");
		
		out.println("<tr>");
		
		out.println("<td style='border: 1px solid black;'>");
		out.println("Server Software");
		out.println("</td>");
		
		out.println("<td style='border: 1px solid black;'>");
		out.println(getServletContext().getServerInfo());
		out.println("</td>");
		
		out.println("</tr>");
		
		out.println("<tr>");
		
		out.println("<td style='border: 1px solid black;'>");
		out.println("Servlet Name");
		out.println("</td>");
		
		out.println("<td style='border: 1px solid black;'>");
		out.println(getServletName() );
		out.println("</td>");
		
		out.println("</tr>");
		
		
		out.println("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
