

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionLogin
 */
@WebServlet(name = "SessionLogin", urlPatterns="/sessionlogin")
public class SessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionLogin() {
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
		String username = "kalwarsushil2";
		String password = "12345678";		
		
		
		String usernameParams = request.getParameter("username");
		String passwordParams = request.getParameter("password");
		
		String error ="";
		
		
		if(passwordParams == null && usernameParams == null ) {
			request.setAttribute(error,"Field is Missing!!");
			doGet(request, response);
			
		}else if(usernameParams.equals(username)&& passwordParams.equals(password)) {
			HttpSession session = request.getSession();
			String sessionId = session.getId();
			System.out.println(sessionId);
            session.setAttribute("username", username);
            session.setAttribute("sessionId", sessionId);
            doGet(request, response);
           
            response.sendRedirect("/college/welcome.jsp");
		}else {
			request.setAttribute(error,"Inavalid Creditals");
			doGet(request, response);
		}
		
		
	}

}
