<%-- 
    Document   : results
    Created on : Nov 19, 2020, 10:53:10 PM
    Author     : Jamie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> The list of Projects:</h1>
        <p>
        <% 
            String details = (String) request.getAttribute("data") ;
            out.print(details);
        
          %>
        </p>  

    </body>
</html>
