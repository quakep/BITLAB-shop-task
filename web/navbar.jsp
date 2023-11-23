<%@ page import="db.User" %>
<div class="container">
    <div class="row">
        <div class="col">
            <nav class="navbar navbar-expand-lg bg-body-tertiary">
                <div class="container-fluid">
                    <a class="navbar-brand" href="shop">BITLAB SHOP</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <%
                                User activeUser = (User) request.getSession().getAttribute("user");
                            %>
                            <li class="nav-item">
                                <a class="nav-link" href="/shop">Shop</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/card">Card</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/register">Register</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/login">Sign in</a>
                            </li>
                            <%
                                if(activeUser!=null){
                            %>
                            <form method="post" action="/logout">
                                <li class="nav-item">
                                    <button class="nav-link">Logout</button>
                                </li>
                            </form>
                            <li class="nav-item">
                                <a class="nav-link" href="/addBlog">Add Blog</a>
                            </li>
                            <%
                                }
                            %>
                            <li class="nav-item">
                                <a class="nav-link" href="/allBlogs">All Blogs</a>
                            </li>
                        </ul>
                        <form class="d-flex" role="search">
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-success" type="submit">Search</button>
                        </form>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</div>
<div class="container mt-3 text-center">
    <div class="row">
        <div class="col">
            <h2>Welcome to BitLab SHOP!</h2>
            <p>Electronic devises with high quality.</p>
        </div>
    </div>
</div>