<%@ page import="db.Blog" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blog Details</title>
    <jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container mt-3">
    <div class="row">
        <div class="col">
            <%
                Blog blog = (Blog) request.getAttribute("blog");
                if(blog!=null){
            %>
                    <div class="mb-3">
                        <label class="form-label">Title</label>
                        <input type="text" readonly class="form-control" value="<%=blog.getTitle()%>" name="title">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Content</label>
                        <input type="text" readonly class="form-control" value="<%=blog.getContent()%>" name="content">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Author</label>
                        <input type="text" readonly class="form-control" value="<%=blog.getUser().getFullName()%>" name="author">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Postdate</label>
                        <input type="text" readonly class="form-control" value="<%=blog.getPostDate()%>" name="postdate">
                    </div>
            <%
                }
            %>
        </div>
    </div>
</div>
</body>
</html>