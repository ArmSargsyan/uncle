package itSpace.uncle.servlet;

import itSpace.uncle.manager.UserManager;
import itSpace.uncle.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    UserManager userManager = new UserManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = userManager.getUserByEmailAndPassword(email, password);
        if (user == null) {
            req.getSession().setAttribute("msg", "Wrong username or password");
            resp.sendRedirect("/");
        } else {
            req.getSession().setAttribute("user", user);
           resp.sendRedirect("/home");
        }
   }
}
