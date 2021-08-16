package itSpace.uncle.servlet;

import itSpace.uncle.manager.ServiceManager;
import itSpace.uncle.model.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    private ServiceManager serviceManager = new ServiceManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //    int userId = Integer.parseInt(req.getParameter("id"));
    //        System.out.println(userId);
       List<Service> services = serviceManager.getServices();
      //  List<Service> services = serviceManager.getServiceByUserId(userId);
       // Service service = serviceManager.getServiceById(userId);
        req.setAttribute("services", services);
        req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);

    }
}
