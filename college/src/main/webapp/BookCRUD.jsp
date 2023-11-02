<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book CRUD Example</title>
</head>
<body>
    <h2>Add a Book</h2>
    <form action="/college/BookCRUDServlet" method="post">
        <input type="hidden" name="action" value="add">
        Book Name: <input type="text" name="name"><br>
        Book Price: <input type="text" name="price"><br>
        <input type="submit" value="Add Book">
    </form>

    <hr>

    <h2>Update a Book</h2>
    <form action="/college/BookCRUDServlet" method="post">
        <input type="hidden" name="action" value="update">
        Book ID: <input type="text" name="id"><br>
        Book Name: <input type="text" name="name"><br>
        Book Price: <input type="text" name="price"><br>
        <input type="submit" value="Update Book">
    </form>

    <hr>

    <h2>Delete a Book</h2>
    <form action="/college/BookCRUDServlet" method="post">
        <input type="hidden" name="action" value="delete">
        Book ID: <input type="text" name="id"><br>
        <input type="submit" value="Delete Book">
    </form>

    <hr>

    <h2>List of Books</h2>
    <form action="/college/BookCRUDServlet" method="get">
        <input type="hidden" name="action" value="list">
        <input type="submit" value="Show Books">
    </form>

    <hr>

    <h2>Message:</h2>
    <p>${message}</p>
</body>
</html>
