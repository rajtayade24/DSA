<%@ page import="java.util.Date" %>
<html>
<head>
    <title>Current Date and Time</title>
</head>
<body>
    <h2>Current Date and Time</h2>

    <%
        Date d = new Date();
    %>

    <p>Current Date and Time: <%= d %></p>
</body>
</html>