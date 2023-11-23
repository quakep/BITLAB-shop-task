<%@ page import="java.util.ArrayList" %>
<%@ page import="db.Item" %>
<%@ page import="db.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <%
            User user = (User) request.getSession().getAttribute("user");
        %>
        <div class="col">
            Email: <%=user.getEmail()%>
            <br>
            Password: <%=user.getPassword()%>
        </div>
    </div>
</div>
</body>
</html>