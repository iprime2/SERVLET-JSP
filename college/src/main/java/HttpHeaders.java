

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpHeaders
 */
@WebServlet("/HttpHeaders")
public class HttpHeaders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HttpHeaders() {
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
		out.println("<h1>" + " HTTP Headers Information" + "</h1>");
		out.println("<table style='width:80%;border: 1px solid black;border-radius: 10px;'>");
		
		out.println("<tr>");
		
		out.println("<th style='width:40%;border: 1px solid black;'>");
		out.println("Headers Name");
		out.println("</th>");
		
		out.println("<th style='width:60%;border: 1px solid black;'>");
		out.println("Headers Value");
		out.println("</th>");
		
		out.println("</tr>");
		
		out.println("<tr>");
		
		out.println("<td style='border: 1px solid black;'>");
		out.println("Host Name");
		out.println("</td>");
		
		out.println("<td style='border: 1px solid black;'>");
		out.println(request.getHeader("Host"));
		out.println("</td>");
		
		out.println("</tr>");
		
		out.println("<tr>");
		
		out.println("<td style='border: 1px solid black;'>");
		out.println("Accept");
		out.println("</td>");
		
		out.println("<td style='border: 1px solid black;'>");
		out.println(request.getHeader("Accept"));
		out.println("</td>");
		
		out.println("</tr>");
		
		out.println("<tr>");
		
		out.println("<td style='border: 1px solid black;'>");
		out.println("Authorization");
		out.println("</td>");
		
		out.println("<td style='border: 1px solid black;'>");
		out.println(request.getHeader("Authorization"));
		out.println("</td>");
		
		out.println("</tr>");
		
		out.println("<tr>");
		
		out.println("<td style='border: 1px solid black;'>");
		out.println("Accept Language");
		out.println("</td>");
		
		out.println("<td style='border: 1px solid black;'>");
		out.println(request.getHeader("Accept-Language"));
		out.println("</td>");
		
		out.println("</tr>");
		
		out.println("<tr>");
		
		out.println("<td style='border: 1px solid black;'>");
		out.println("Accept Character Set:");
		out.println("</td>");
		
		out.println("<td style='border: 1px solid black;'>");
		out.println(request.getHeader("Accept-Charset"));
		out.println("</td>");
		
		out.println("</tr>");
		
		out.println("<tr>");
		
		out.println("<td style='border: 1px solid black;'>");
		out.println("Accept Encoding");
		out.println("</td>");
		
		out.println("<td style='border: 1px solid black;'>");
		out.println(request.getHeader("Accept-Encoding"));
		out.println("</td>");
		
		out.println("</tr>");
		
		out.println("<tr>");
		
		out.println("<td style='border: 1px solid black;'>");
		out.println("User Agent");
		out.println("</td>");
		
		out.println("<td style='border: 1px solid black;'>");
		out.println(request.getHeader("User-Agent"));
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
