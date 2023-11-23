<%@ page import="java.util.ArrayList" %>
<%@ page import="db.Item" %>
<%@ page import="db.CardItem" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
    <title>Card</title>
</head>
<body>
<%@include file="navbar.jsp"%>
<%ArrayList<CardItem> items = (ArrayList<CardItem>) request.getSession().getAttribute("cardItems");
    if (items!=null){
%>
<div class="container mt-3">
    <div class="col">
        <%
            for(CardItem item: items){
        %>
        <div class="col">
            <div class="card">
                <div class="card-header">
                    <%=item.getItem().getName()%>
                </div>
                <div class="card-body">
                    <img src="<%=item.getItem().getPhotoURL()%>" class="card-img-top" style="width: 150px">
                    <h5 class="card-title"> <%=item.getItem().getPrice()%></h5>
                    <p class="card-text"><%=item.getItem().getDescription()%></p>
                    <label>Amount:</label>
                    <input type="text" name="amount" value="<%=item.getCount()%>">
                </div>
            </div>
        </div>
        <%
            }
        %>
    </div>
</div>
<%
    }
%>
</body>
</html>