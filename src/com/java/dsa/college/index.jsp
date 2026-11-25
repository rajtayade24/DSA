<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Website Visit Counter</title>
</head>
<body>

    <h2>Welcome  Website!</h2>

    <%
        Integer count = (Integer) application.getAttribute("counter");

        if (count == null) {
            count = 1;
        } else {
            count++;
        }

        application.setAttribute("counter", count);
    %>

    <h3>Total Website Visits: <%= count %></h3>

</body>
</html>