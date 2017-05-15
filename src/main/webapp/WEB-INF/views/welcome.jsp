<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 5/8/2017
  Time: 1:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Demo</title>
</head>
<body>
<%--${hello}--%>
<a href="getNewCustomer">Add Customer</a><br/>

<table border="1">
<%--forEach if it is red alt + enter see top -- for(CustomerEntity c:customerList){sout(c);}
/delete?id=${cust.customerId}">Delete--%>

<c:forEach var="cust" items = "${cList}">

    <tr>
        <td>${cust.customerId}</td>
        <td>${cust.companyName}</td>
        <td><a href="/delete?id=${cust.customerId}">Delete</a></td>
    </tr>

</c:forEach>

</table>


</body>
</html>
