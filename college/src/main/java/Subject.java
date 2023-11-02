

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Subject
 */
@WebServlet("/Subject")
public class Subject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Subject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String selectedSubject = request.getParameter("subject");
	     
        boolean cookieExists = false;
        Cookie[] cookies = request.getCookies();
        Cookie subjectCookie;
        String subjectValue = "None"; 
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("subject")) {
                    cookieExists = true;
                    subjectValue = cookie.getValue();
                    break;
                }
            }
        }

        
        if(selectedSubject != null && !selectedSubject.isEmpty()) {
        	if (!cookieExists ) {
            	subjectCookie = new Cookie("subject", selectedSubject);
                subjectCookie.setMaxAge(24 * 60 * 60); 
                response.addCookie(subjectCookie);
                subjectValue = subjectCookie.getValue();
        	}else {
        		for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("subject")) {
                        cookie.setValue(selectedSubject);
                        response.addCookie(cookie);
                        break;
                    }
                }
        	}
        }
        
        request.setAttribute("subjectCookie", subjectValue);
        doGet(request, response);
        getServletContext().getRequestDispatcher("/subject.jsp").forward(request, response);
	}

}
