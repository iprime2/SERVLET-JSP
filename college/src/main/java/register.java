

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class register
 * sushil
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String desiredLogin = request.getParameter("desiredLogin");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String location = request.getParameter("location");
        String education = request.getParameter("education");
        String phoneNumber = request.getParameter("phoneNumber");
        
	
		
		if (!firstName.matches("[a-zA-Z]+")) {
        	request.setAttribute("error", "First Name should contain only alphabets.");
			doGet(request, response);
        }else if (!middleName.matches("[a-zA-Z]+")) {
        	request.setAttribute("error", "Middle Name should contain only alphabets.");
			doGet(request, response);
        }else if (!lastName.matches("[a-zA-Z]+")) {
        	request.setAttribute("error", "Last Name should contain only alphabets.");
			doGet(request, response);	
        }else if(!password.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{6,}$") ){
        	request.setAttribute("error", "Paswword do not meet the requirement");
			doGet(request, response); 
        }else if (!password.equals(confirmPassword)) {
        	request.setAttribute("error", "Paswword do not match");
			doGet(request, response);            
        }else {
        	request.setAttribute("success", "Successful Registration!!");
        	doGet(request, response); 
        }
        
        
	}

}
