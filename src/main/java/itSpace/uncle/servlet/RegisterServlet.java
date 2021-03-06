package itSpace.uncle.servlet;

import itSpace.uncle.manager.UserManager;
import itSpace.uncle.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    UserManager userManager = new UserManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String numberPhone = req.getParameter("numberPhone");

        User user = User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .numberPhone(numberPhone)
                .build();
        userManager.addUser(user);
        req.getSession().setAttribute("msg", "user was register successfully");
        resp.sendRedirect("/");
    }
}
