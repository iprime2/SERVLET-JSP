<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
        // Accessing session information using the session object
        HttpSession session2 = request.getSession();

        // Checking if a session exists
        boolean isNewSession = session.isNew();

        // Getting session ID
        String sessionId = session.getId();

        // Getting last accessed time
        long lastAccessedTime = session.getLastAccessedTime();

        // Getting session creation time
        long creationTime = session.getCreationTime();

        // Getting session attributes
        String username = (String) session.getAttribute("username");
    %>

    <h2>Session Information</h2>
    <p>New Session: <%= isNewSession %></p>
    <p>Session ID: <%= sessionId %></p>
    <p>Last Accessed Time: <%= new java.util.Date(lastAccessedTime) %></p>
    <p>Creation Time: <%= new java.util.Date(creationTime) %></p>
    <p>Username: <%= username %></p>
</body>
</html>