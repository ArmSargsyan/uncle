<%@ page import="itSpace.uncle.model.Service" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <title>Index</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body background="/css/img/carousel-1.jpg">
<% String msg = (String) session.getAttribute("msg");%>
<%Service service = (Service) request.getAttribute("service");%>
<% if (msg != null && !"".equals(msg)) { %>
<span><%=msg%></span>
<%
    session.removeAttribute("msg"); }
%>
<h1>Update</h1> <h4> <a href="/logout">Logout</a></h4>  <h4><a href="/home">Home</a></h4>

<div class="container">
    <table id="myTable" class=" table order-list">
        <thead>
        <tr>
            <td>Title</td>
            <td>Description</td>
            <td>Visitor Name</td>
            <td>Date</td>
        </tr>
        </thead>
        <tbody >
        <tr>
            <form action="/updateService" method="post">
                <input  type="hidden" name="id" value="<%=service.getId()%>">
                <td class="col-sm-3" >
                    <input type="text" name="title" class="form-control" value="<%=service.getTitle()%>" />
                </td>
                <td class="col-sm-3">
                    <input type="text" name="description"  class="form-control" value="<%=service.getDescription()%>"/>
                </td>
                <td class="col-sm-3">
                    <input type="text" name="visitorName"  class="form-control"  value="<%=service.getVisitorName()%>"/>
                </td>
                <td class="col-sm-3">
                    <input type="date" name="date"  class="form-control" value=" <%=service.getDate()%>"/>
                </td>

        </tr>
        </tbody>
        <tfoot>
        <tr>
            <td  colspan="5" style="text-align: left;">
                <%--                <form action="/addService" method="post">--%>
                <input type="submit" class="btn btn-lg btn-block " id="addService" value="Update" />
                </form>
            </td>
        </tr>
        <tr>
        </tr>
        </tfoot>
    </table>
</div>


<script>
    $(document).ready(function () {
        var counter = 0;

        $("#addService").on("click", function () {
            var newRow = $("<tr>");
            var cols = "";

            cols += '<td><input type="text" class="form-control" name="title' + counter + '"/></td>';
            cols += '<td><input type="text" class="form-control" name="description' + counter + '"/></td>';
            cols += '<td><input type="text" class="form-control" name="visitorName' + counter + '"/></td>';
            cols += '<td><input type="date" class="form-control" name="date' + counter + '"/></td>';

            cols += '<td><input type="submit" class="ibtnDel btn btn-md btn-danger "  value="Delete"></td>';
            newRow.append(cols);
            $("table.order-list").append(newRow);
            counter++;
        });
</script>



</form>
</body>
</html>
