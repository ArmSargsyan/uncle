package itSpace.uncle.servlet;

import itSpace.uncle.manager.ServiceManager;
import itSpace.uncle.model.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/singleService")
public class SingleServiceServlet extends HttpServlet {

    private ServiceManager serviceManager = new ServiceManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Service service = serviceManager.getServiceById(id);

        req.setAttribute("service", service);
        req.getRequestDispatcher("/WEB-INF/singleService.jsp").forward(req, resp);

    }
}