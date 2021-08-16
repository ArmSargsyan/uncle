package itSpace.uncle.servlet;

import itSpace.uncle.manager.ServiceManager;
import itSpace.uncle.model.Service;
import itSpace.uncle.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/addService")
public class AddServiceServlet extends HttpServlet {

    private ServiceManager serviceManager = new ServiceManager();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addService.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String date = req.getParameter("date");
        String visitorName = req.getParameter("visitorName");

        Service service = Service.builder()
                .title(title)
                .description(description)
                .date(date)
                .visitorName(visitorName)
                .user(user)
                .build();

        serviceManager.addService(service);
        req.getSession().setAttribute("msg", "service was added");
        resp.sendRedirect("/home");


    }
}
