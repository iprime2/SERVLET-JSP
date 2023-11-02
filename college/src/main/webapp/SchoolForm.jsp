<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>School Form</title>
</head>
<body>
<h1>School Form</h1>
<form method="post" action="/college/collegeForm">
    <table>
        <tr>
            <td><label for="email">E-mail</label></td>
            <td><input type="email" id="email" name="email"></td>
        </tr>
        <tr>
            <td><label for="password">Password</label></td>
            <td><input type="password" id="password" name="password"></td>
        </tr>
        <tr>
            <td><label for="birthday">Birthday</label></td>
            <td><input type="date" id="birthday" name="birthday"></td>
        </tr>
        <tr>
            <td><label for="newStudent">New Student?</label></td>
            <td>
                <input type="radio" id="newStudent" name="newStudent" value="Yes">Yes
                <input type="radio" id="newStudent" name="newStudent" value="No">No
            </td>
        </tr>
        <tr>
            <td><label for="college">College</label></td>
            <td><input type="text" id="college" name="college"></td>
        </tr>
        <tr>
            <td><label for="major">Major</label></td>
            <td>
                <select id="major" name="major">
                    <option value="Computer Science">Computer Science</option>
                    <option value="Commerce">Commerce</option>
                    <option value="Physics">Physics</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><label for="favcolor">Favorite color:</label></td>
            <td><input type="color" id="favcolor" name="favcolor" value="#ff0000"></td>
        </tr>
        <tr>
            <td><label for="terms">Terms and Conditions</label></td>
            <td><input type="checkbox" id="terms" name="terms" value="agree">Yes</td>
        </tr>
    </table>
    <br>
    <button type="reset">Reset Form</button>
    <button type="submit">Submit Form</button>
</form>
</body>
</html>
