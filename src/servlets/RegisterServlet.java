package servlets;

import db.DBManager;
import db.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "/register?emailError";
        String fullname = req.getParameter("fullName");
        String password  = req.getParameter("password");
        String passwordRep  = req.getParameter("passwordRepeat");
        String email  = req.getParameter("email");

        User existUser = DBManager.getUserByEmail(email);

        if (existUser == null) {
            if (password.equals(passwordRep)) {
                User user = new User();
                user.setEmail(email);
                user.setFullName(fullname);
                user.setPassword(password);
                DBManager.addUser(user);
                redirect = "/login";
            } else {
                redirect = "/register?passwordError";
            }
        }

        resp.sendRedirect(redirect);
    }
}