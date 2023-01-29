<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@include file="menu.jsp"%> 
        
            
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>bills</title>
</head>
<body>
<form action="listALLBills" method="post">
<table>
<tr>
<th>FirstName</th>
<th>LastName</th>
<th>Email</th>
<th>Mobile</th>
<th>Product</th>
<th>Amount</th>

</tr>



<c:forEach var="allBills" items="${allBills}">
<tr>
<td>${allBills.firstName}</td>
<td>${allBills.lastName}</td>
<td>${allBills.email}</td>
<td>${allBills.mobile}</td>
<td>${allBills.product}</td>
<td>${allBills.amount}</td>


</tr>
</c:forEach>
  </table> 
 </form>
</body>
</html>