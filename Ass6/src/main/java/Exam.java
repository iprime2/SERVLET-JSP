

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Exam
 */
@WebServlet("/Exam")
public class Exam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exam() {
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
		doGet(request, response);
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    HttpSession session = request.getSession(true);

	    int correctAnswers = 0;
	    int wrongAnswers = 0;

        String[] correctAnswersArray = {"b", "c", "a", "d", "a", "c", "b", "d", "a", "c"};

        String[] userAnswersArray = new String[10];
        userAnswersArray[0] = request.getParameter("q1");
        userAnswersArray[1] = request.getParameter("q2");
        userAnswersArray[2] = request.getParameter("q3");
        userAnswersArray[3] = request.getParameter("q4");
        userAnswersArray[4] = request.getParameter("q5");
        userAnswersArray[5] = request.getParameter("q6");
        userAnswersArray[6] = request.getParameter("q7");
        userAnswersArray[7] = request.getParameter("q8");
        userAnswersArray[8] = request.getParameter("q9");
        userAnswersArray[9] = request.getParameter("q10");

        out.println("<br />");
        for (int i = 0; i < 10; i++) {
            out.println("Question " + (i + 1) + ": Correct answer is " + correctAnswersArray[i]);
            if (userAnswersArray[i] != null && userAnswersArray[i].equals(correctAnswersArray[i])) {
                out.println(" - Your answer is correct<br>");
                correctAnswers++;
            } else {
                out.println(" - Your answer is incorrect<br>");
                wrongAnswers++;
            }
        }

	    long startTime = (Long) session.getAttribute("startTime");
	    long endTime = System.currentTimeMillis();
	    long duration = endTime - startTime;

	    long durationInSeconds = duration / 1000;

	    long minutes = durationInSeconds / 60;
	    long seconds = durationInSeconds % 60;

	    out.println("<h2>Exam Result</h2>");
	    out.println("Duration: " + minutes + " minutes and " + seconds + " seconds<br>");
	    out.println("Correct Answers: " + correctAnswers + "<br>");
	    out.println("Wrong Answers: " + wrongAnswers + "<br>");
	}
}
