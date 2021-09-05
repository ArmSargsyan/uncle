
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <title>Index</title>
</head>
<body background="/css/img/carousel-2.jpg">


<% String msg = (String) session.getAttribute("msg");%>
<% if (msg != null && !"".equals(msg)) { %>
<span><%=msg%></span>
<%
        session.removeAttribute("msg");
    }%>
<h1>AddService</h1> | <a href="/logout">Logout</a> | <a href="/home">Home</a>

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
            <form action="/addService" method="post">
            <td class="col-sm-3" >
                <input type="text" name="title" class="form-control" />
            </td>
            <td class="col-sm-3">
                <input type="text" name="description"  class="form-control"/>
            </td>
            <td class="col-sm-3">
                <input type="text" name="visitorName"  class="form-control"/>
            </td>
            <td class="col-sm-3">
                <input type="date" name="date"  class="form-control"/>
            </td>

            <td class="col-sm-2"><a class="deleteRow"></a>

            </td>

        </tr>
        </tbody>
        <tfoot>
        <tr>
            <td  colspan="5" style="text-align: left;">
<%--                <form action="/addService" method="post">--%>
                <input type="submit" class="btn btn-lg btn-block " id="addService" value="Add Service" />
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



    $("table.order-list").on("click", ".ibtnDel", function (event) {
    $(this).closest("tr").remove();
    counter -= 1
    });


    });



    function calculateRow(row) {
    var price = +row.find('input[name^="price"]').val();

    }

    function calculateGrandTotal() {
    var grandTotal = 0;
    $("table.order-list").find('input[name^="price"]').each(function () {
    grandTotal += +$(this).val();
    });
    $("#grandtotal").text(grandTotal.toFixed(2));
    }
</script>
</body>
</html>
