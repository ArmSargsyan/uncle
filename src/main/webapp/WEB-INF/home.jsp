<%@ page import="itSpace.uncle.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="itSpace.uncle.model.Service" %>
<%@ page import="itSpace.uncle.manager.UserManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Index</title>

</head>
<body background="/css/img/carousel-2.jpg" >



<% User user = (User) session.getAttribute("user");
    //UserManager userManager = new UserManager();
//String id = String.valueOf(user.getId());

//    System.out.println(id);
//session.setAttribute("id",id);
//Service service = (Service) session.getAttribute("service");
    String msg = (String) session.getAttribute("msg");%>
<% if (msg != null && !"".equals(msg)) { %>
<span><%=msg%></span>
<%
        session.removeAttribute("msg");
    }%>


<% List<Service> services = (List<Service>) request.getAttribute("services");%>
Welcome <%=user.getName()%> | <a href="/logout">Logout</a> |
<a href="/addService">Add Service</a>


<table border="3" style="background: #aeaeec">
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Date</th>
        <th>Visitor Name</th>
    </tr>
    <% if (services != null && !services.isEmpty()) {
        for (Service service : services) {

    %>
    <tr>
        <td><%=service.getTitle() %>
        </td>
        <td><%=service.getDescription()%>
        </td>
        <td><%=service.getDate()%>
        </td>
        <td><%=service.getVisitorName()%>
        </td>

    </tr>
   <tr> <td><a href="/singleService?id=<%=service.getId()%>">Show more</a> | <a
            href="/updateService?id=<%=service.getId()%>">Update</a> | <a
            href="/deleteService?id=<%=service.getId()%>">Delete</a></td>
    </tr>

    <% }
    }%>


</table>

</body>
</html>
