

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterCookieServlet
 */
@WebServlet("/RegisterCookieServlet")
public class RegisterCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCookieServlet() {
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
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        // Create cookies for each parameter
        Cookie nameCookie = new Cookie("name", name);
        Cookie ageCookie = new Cookie("age", String.valueOf(age));
        Cookie phoneCookie = new Cookie("phone", phone);
        Cookie emailCookie = new Cookie("email", email);

        int cookieExpirationTime = 2 * 60;
        nameCookie.setMaxAge(cookieExpirationTime);
        ageCookie.setMaxAge(cookieExpirationTime);
        phoneCookie.setMaxAge(cookieExpirationTime);
        emailCookie.setMaxAge(cookieExpirationTime);

        response.addCookie(nameCookie);
        response.addCookie(ageCookie);
        response.addCookie(phoneCookie);
        response.addCookie(emailCookie);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Registration Details:</h3>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Age: " + age + "</p>");
        out.println("<p>Phone: " + phone + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</body></html>");

        String redirectUrl = "https://www.google.com/search?q=Name="+ name + "-age=" + age + "-phone="+ phone + "-email=" + email;
        response.sendRedirect(redirectUrl);
		
//		doGet(request, response);
//        getServletContext().getRequestDispatcher("/subject.jsp").forward(request, response);
	}

}
