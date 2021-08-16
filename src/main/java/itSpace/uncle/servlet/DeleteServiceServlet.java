package itSpace.uncle.servlet;

import itSpace.uncle.manager.ServiceManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteService")
public class DeleteServiceServlet extends HttpServlet {

    private ServiceManager serviceManager = new ServiceManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int serviceId = Integer.parseInt(req.getParameter("id"));
        serviceManager.deleteService(serviceId);
        req.getSession().setAttribute("msg", "service deleted");
        resp.sendRedirect("/");
    }
}
