<%--
  Created by IntelliJ IDEA.
  User: Blackhawkkk1
  Date: 25-May-20
  Time: 12:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login success page</title>
</head>
<body>
<h1> Hi <%
    out.println("<b>" + request.getAttribute("user") + "</b>");
%> Login success.</h1>
<a href="Login.html">Login page</a>
</body>
</html>
