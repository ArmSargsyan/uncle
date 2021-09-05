<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="itSpace.uncle.model.Service" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body background="/css/img/faqs.jpg" >
<%
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    Service service = (Service) request.getAttribute("service");
%>
<a href="/home" >Go Home</a> | <a href="/logout">Logout</a>

<h1> <%=service.getTitle()%></h1>

<table border="3" style="background: #aeaeec">
    <tr>
        <th style="width: 120px">Description</th>
        <th style="width: 100px">Date</th>
        <th style="width: 100px">Visitor Name</th>
        <th style="width: 100px">User name</th>
        <th style="width: 100px">User Surname</th>
    </tr>

    <tr>

        <td><%=service.getDescription()%>
        </td>
        <td><%=service.getDate()%>
        </td>
        <td><%=service.getVisitorName()%>
        </td>
        <td><%=service.getUser().getName()%>
        </td>
        <td><%=service.getUser().getSurname()%>
        </td>

    </tr>


</table>
</body>
</html>
