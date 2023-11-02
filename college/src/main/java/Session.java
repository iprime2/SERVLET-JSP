

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Session
 */
@WebServlet("/Session")
public class Session extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Session() {
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
        
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		System.out.println(sessionId);
		long createTime = session.getCreationTime();
		System.out.println(createTime);
		long lastAccessedTime = session.getLastAccessedTime();
		System.out.println(lastAccessedTime);
        
        session.setAttribute("sessionId", sessionId);
        
        boolean isFirstVisit = (session.isNew());
        
        if (isFirstVisit) {
            out.println("<h1>Welcome! This is your first visit.</h1>");
        } else {
            out.println("<h1>Welcome back! You have visited this page before.</h1>");
        }
        
        out.println("<p>Session ID: " + session.getId() + "</p>");
        
        session.invalidate();
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
