package com.sushil.compoundServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet(name = "CalculatorServlet", urlPatterns= {"","/"})
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String principalAmount = request.getParameter("principalamount");
		String interestPercentage = request.getParameter("interestPercentage");
		String years = request.getParameter("years");
		String compoundingPeriod = request.getParameter("compoundingPeriod"); 
		
		String error;
		
		if(principalAmount == null || principalAmount.isBlank() || interestPercentage == null || interestPercentage.isBlank() || years == null || years.isBlank() || compoundingPeriod == null || compoundingPeriod.isBlank() ) {
			error="One or more of the input boxes were blank. Try again.";
			
			request.setAttribute("error", error);
		}else {
			double result = Utils.calculateCompoundInterest(Double.parseDouble(principalAmount), (Double.parseDouble(interestPercentage) / 100), Integer.parseInt(years), Integer.parseInt(compoundingPeriod));
			request.setAttribute("result", result);
		}
		
			request.setAttribute("principal", principalAmount);
			request.setAttribute("interestPercentage", interestPercentage);
			request.setAttribute("years", years);
			request.setAttribute("compoundingPeriod", compoundingPeriod);
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
