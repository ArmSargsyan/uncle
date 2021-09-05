package itSpace.uncle.servlet;

import itSpace.uncle.manager.ServiceManager;
import itSpace.uncle.model.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateService")
public class UpdateServiceServlet extends HttpServlet {

    private ServiceManager serviceManager = new ServiceManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int serviceId = Integer.parseInt(req.getParameter("id"));
        Service service = serviceManager.getServiceById(serviceId);
        req.setAttribute("service", service);
        req.getRequestDispatcher("/WEB-INF/updateService.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int serviceId = Integer.parseInt(req.getParameter("id"));
        Service serviceById = serviceManager.getServiceById(serviceId);
        if (serviceById != null) {

            String title = req.getParameter("title");
            String description = req.getParameter("description");
            String date = req.getParameter("date");
            String visitorName = req.getParameter("visitorName");

            Service service = Service.builder()
                    .id(serviceId)
                    .title(title)
                    .description(description)
                    .date(date)
                    .visitorName(visitorName)
                    .build();
            serviceManager.updateService(service);
            req.getSession().setAttribute("msg", "service was update");
            resp.sendRedirect("/home");
        }
    }
}