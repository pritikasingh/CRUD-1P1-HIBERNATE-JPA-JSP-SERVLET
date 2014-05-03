<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retrieve Person</title>
</head>


<body>

<table border="1">

<tr>

<th>Name</th>
<th>Street</th>
<th>Number</th>
<th>District</th>
<th>Update</th>
<th>Delete</th>

</tr>

<c:forEach items="${listPerson}" var="person">


<tr>

<td>${person.namePerson}</td>
<td>${person.address.streetAddress}</td>
<td>${person.address.numberAddress}</td>
<td>${person.address.districtAddress}</td>
<td><a href="UpdatePersonController?cmd=update1&idPerson=${person.idPerson}">Update</a> </td>
<td><a href="DeletePersonController?idPerson=${person.idPerson}">Delete</a> </td>


</tr>

</c:forEach>

</table>


${msg}

<br/>
<br/>

<a href="createPerson.jsp">Create Person</a>
<br/>
<a href="index.jsp">Back to Index</a>

</body>


</html>