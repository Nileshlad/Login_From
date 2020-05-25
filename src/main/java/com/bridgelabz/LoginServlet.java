package com.bridgelabz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(
        description = "Login servlet testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "namePattern", value = "^[A-Z]+[A-Za-z0-9]{2}$"),
                @WebInitParam(name = "passwordPattern", value = "^(?=.*[A-Z])(?=.*[@#$*+.!%&-])(?=.*[0-9])[a-zA-Z0-9]*.{8,}$"),
                @WebInitParam(name = "userId", value = "Jitesh")
        }
)

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("name");
        String userId = request.getParameter("userName");
        String password = request.getParameter("password");


        String user = getServletConfig().getInitParameter("userId");
        String passwordPattern = getServletConfig().getInitParameter("passwordPattern");
        String namePattern = getServletConfig().getInitParameter("namePattern");

        if (userId.equals(user) && Pattern.matches(passwordPattern, password) && Pattern.matches(namePattern, userName)) {
            request.setAttribute("user", userId);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red> Either username and password is wrong </font>");
            requestDispatcher.include(request, response);
        }
    }
}