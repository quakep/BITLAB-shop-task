<%@ page import="java.util.ArrayList" %>
<%@ page import="db.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
    <title>Blog Adding</title>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container mt-3">
    <div class="row">
        <div class="col">
            <form method="post" action="/addBlog">
                <div class="mb-3">
                    <label class="form-label">Title</label>
                    <input type="text" class="form-control" name="title">
                </div>
                <div class="mb-3">
                    <label  class="form-label">Content</label>
                    <textarea class="form-control" name="content"></textarea>
                </div>
                <div class="mb-3">
                    <button type="submit" class="btn btn-success">ADD BLOG</button>
                </div>
            </form>
        </div>
    </div>
</div>
</div>
</body>
</html>