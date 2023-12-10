<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Exam</title>
</head>
<body>
<%
	session.setAttribute("startTime", System.currentTimeMillis());

	long startTime = (Long) session.getAttribute("startTime");

%>
	<form action="exam.jsp" method="post">
    <h2>Online Examination</h2>
    <ol>
      <li>
        <label>What is the capital of France?</label><br>
        <input type="radio" name="q1" value="a">a) Paris<br>
        <input type="radio" name="q1" value="b">b) Berlin<br>
        <input type="radio" name="q1" value="c">c) London<br>
        <input type="radio" name="q1" value="d">d) Madrid<br>
      </li>
      <li>
        <label>Who is the author of "To Kill a Mockingbird"?</label><br>
        <input type="radio" name="q2" value="a">a) Harper Lee<br>
        <input type="radio" name="q2" value="b">b) J.K. Rowling<br>
        <input type="radio" name="q2" value="c">c) Stephen King<br>
        <input type="radio" name="q2" value="d">d) Ernest Hemingway<br>
      </li>
      <li>
        <label>What is the chemical symbol for gold?</label><br>
        <input type="radio" name="q3" value="a">a) Au<br>
        <input type="radio" name="q3" value="b">b) Ag<br>
        <input type="radio" name="q3" value="c">c) Fe<br>
        <input type="radio" name="q3" value="d">d) Cu<br>
      </li>
      <li>
        <label>In which year did the Titanic sink?</label><br>
        <input type="radio" name="q4" value="a">a) 1912<br>
        <input type="radio" name="q4" value="b">b) 1914<br>
        <input type="radio" name="q4" value="c">c) 1916<br>
        <input type="radio" name="q4" value="d">d) 1918<br>
      </li>
      <li>
        <label>What is the largest planet in our solar system?</label><br>
        <input type="radio" name="q5" value="a">a) Jupiter<br>
        <input type="radio" name="q5" value="b">b) Saturn<br>
        <input type="radio" name="q5" value="c">c) Uranus<br>
        <input type="radio" name="q5" value="d">d) Neptune<br>
      </li>
      <li>
        <label>Who painted the Mona Lisa?</label><br>
        <input type="radio" name="q6" value="a">a) Leonardo da Vinci<br>
        <input type="radio" name="q6" value="b">b) Vincent van Gogh<br>
        <input type="radio" name="q6" value="c">c) Pablo Picasso<br>
        <input type="radio" name="q6" value="d">d) Michelangelo<br>
      </li>
      <li>
        <label>What is the boiling point of water in Celsius?</label><br>
        <input type="radio" name="q7" value="a">a) 100<br>
        <input type="radio" name="q7" value="b">b) 0<br>
        <input type="radio" name="q7" value="c">c) 50<br>
        <input type="radio" name="q7" value="d">d) 200<br>
      </li>
      <li>
        <label>What is the powerhouse of the cell?</label><br>
        <input type="radio" name="q8" value="a">a) Mitochondria<br>
        <input type="radio" name="q8" value="b">b) Nucleus<br>
        <input type="radio" name="q8" value="c">c) Ribosome<br>
        <input type="radio" name="q8" value="d">d) Golgi Apparatus<br>
      </li>
      <li>
        <label>Who is the current President of the United States?</label><br>
        <input type="radio" name="q9" value="a">a) Joe Biden<br>
        <input type="radio" name="q9" value="b">b) Donald Trump<br>
        <input type="radio" name="q9" value="c">c) Barack Obama<br>
        <input type="radio" name="q9" value="d">d) George W. Bush<br>
      </li>
      <li>
        <label>What is the formula for the area of a rectangle?</label><br>
        <input type="radio" name="q10" value="a">a) length x height<br>
        <input type="radio" name="q10" value="b">b) length + height<br>
        <input type="radio" name="q10" value="c">c) length / height<br>
        <input type="radio" name="q10" value="d">d) length - height<br>
      </li>
    </ol>

    <input type="submit" value="Submit">
  </form>
  <%
  response.setContentType("text/html");

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

  long endTime = System.currentTimeMillis();
  long duration = endTime - startTime;

  long durationInSeconds = duration / 1000;

  long minutes = durationInSeconds / 60;
  long seconds = durationInSeconds % 60;

  out.println("<h2>Exam Result</h2>");
  out.println("Duration: " + minutes + " minutes and " + seconds + " seconds<br>");
  out.println("Correct Answers: " + correctAnswers + "<br>");
  out.println("Wrong Answers: " + wrongAnswers + "<br>");
  %>
</body>
</html>