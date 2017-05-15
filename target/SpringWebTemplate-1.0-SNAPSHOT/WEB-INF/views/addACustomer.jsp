<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 5/15/2017
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a Customer</title>
</head>
<body>
<form action="addCustomer" method="post">

    Customer ID <input type="text" name="custID"><br/>
    Customer Name <input type="text" name="compName"><br/>
    Customer Name <input type="text" name="contName"><br/>
    Customer Title <input type="text" name="contTitle"><br/>
    Address <input type="text" name="address"><br/>
    City<input type="text" name="city"><br/>
    Region<input type="text" name="region"><br/>
    Postal Code<input type="text" name="pCode"><br/>
    Country<input type="text" name="country"><br/>
    Phone<input type="text" name="phone"><br/>
    Fax<input type="text" name="fax"><br/>

    <input type="submit" name="Add"><br/>


</form>

</body>
</html>
