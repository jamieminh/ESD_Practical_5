<%-- 
    Document   : add
    Created on : Nov 26, 2020, 9:41:20 PM
    Author     : WIN 10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a new project</title>
    </head>
    <body>
        <h2>Enter Project Details</h2>
        
        <form method="post" action="/Practical_5/AddProjectServlet" >
            Student ID: <input type="text" name="studentID"> <br>
            Student Name: <input type="text" name="studentName"> <br>
            Project Title: <input type="text" name="projectTitle"> <br>
            <input type="submit" value="Submit"> <br>
        </form>

        
        <%=request.getAttribute("data")%>
        
        <form action="/Practical_5/index_db.html" method="post">
            <input type="submit" value="Main Menu"> <br>
        </form>
    </body>
</html>
