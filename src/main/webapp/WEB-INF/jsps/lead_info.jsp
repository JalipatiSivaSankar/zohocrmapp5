<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@include file="menu.jsp"%> 

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lead info</title>
</head>
<body>
<h2>Lead | Info </h2>
<hr>
<form action="compose" method="post">
<input type="hidden" name="email" value="${lead.email}"/>
<input type="submit" value="send email"/>

</form>
<form action="convertLead" method="post">
<input type="hidden" name="id" value="${lead.id}"/>
<input type="submit" value="convert"/>
</form>

${msg}<br/>
FirstName: ${lead.firstName}<br/>
lastName: ${lead.lastName}<br/>
email id: ${lead.email}<br/>
mobile: ${lead.mobile}<br/>
source: ${lead.source}<br/>
</body>
</html>