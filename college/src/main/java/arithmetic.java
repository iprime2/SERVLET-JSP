

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class arithmetic
 */
@WebServlet("/arithmetic")
public class arithmetic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public arithmetic() {
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
		try {
			 int number1 = Integer.parseInt(request.getParameter("number1"));
	         int number2 = Integer.parseInt(request.getParameter("number2"));
	         String operator = request.getParameter("operator");

	         double result = 0;
	         String error = null;
	
	         switch (operator) {
	         case "+":
	             result = number1 + number2;
	             break;
	         case "-":
	             result = number1 - number2;
	             break;
	         case "*":
	             result = number1 * number2;
	             break;
	         case "/":
	             if (number2 == 0) {
	                 error = "Division by zero is not allowed.";
	             } else {
	                 result = number1 / number2;
	             }
	             break;
	         default:
	             error = "Invalid operator.";
	             break;
	     }
	         request.setAttribute("result", result);
	         request.setAttribute("error", error);
	         getServletContext().getRequestDispatcher("/arithmetic.jsp").forward(request, response);
		} catch (NumberFormatException e) {
	        request.setAttribute("error", e);
	        request.getRequestDispatcher("/arithmetic.jsp").forward(request, response);
	    } catch (ArithmeticException e) {
	        request.setAttribute("error", e);
	        request.getRequestDispatcher("/arithmetic.jsp").forward(request, response);
	    }
	}

}
