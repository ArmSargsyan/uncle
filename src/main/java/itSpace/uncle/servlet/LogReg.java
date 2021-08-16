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

@WebServlet(urlPatterns = "/logReg")
public class LogReg extends HttpServlet {

    ServiceManager serviceManager = new ServiceManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Service> services = serviceManager.getServices();
        req.setAttribute("services", services);
        req.getRequestDispatcher("/WEB-INF/loginTable.jsp").forward(req, resp);
    }
    }
