<%@ page import="db.Blog" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="db.DBManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Blogs</title>
    <jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container">
    <div class="row">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Author</th>
                    <th>Title</th>
                    <th>Postdate</th>
                    <th>Details</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<Blog> blogs = DBManager.getAllBlogs();
                    if (blogs != null) {
                        for (Blog blog : blogs) {
                %>
                <form action="/blogDetails?id=<%=blog.getId()%>" method="get">
                    <tr>
                        <td><%= blog.getId() %></td>
                        <td><%= blog.getUser().getFullName() %></td>
                        <td><%= blog.getTitle() %></td>
                        <td><%= blog.getPostDate() %></td>
                        <td><button type="submit" class="btn btn-dark">More...</button></td>
                        <td><input type="hidden" value="<%= blog.getId() %>" name="id"></td>
                    </tr>
                </form>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
    </div>
</div>
</body>
</html>