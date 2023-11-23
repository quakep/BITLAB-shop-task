<%@ page import="java.util.ArrayList" %>
<%@ page import="db.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop</title>
    <jsp:include page="head.jsp"></jsp:include>
</head>
<body>
    <jsp:include page="navbar.jsp"></jsp:include>
    <div class="container">
        <div class="row">
            <%
                ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("items");
                if(items!=null){
                    for(Item item:items){
            %>
            <div class="col">
                <form action="/card" method="post">
                    <div class="card">
                        <input type="hidden" name="id" value="<%=item.getId()%>">
                        <div class="card-header">
                            <%=item.getName()%>
                        </div>
                        <div class="card-body">
                            <img src="<%=item.getPhotoURL()%>" class="card-img-top" alt="where is photo?">
                            <h5 class="card-title"><%=item.getPrice()%></h5>
                            <p class="card-text"><%=item.getDescription()%></p>
                            <button class="btn btn-primary">Add to Card</button>
                        </div>
                    </div>
                </form>
            </div>
            <%
                    }
                }
            %>
        </div>
    </div>
</body>
</html>
