<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Person</title>
</head>
<body>

<h2>Update Person</h2>

<form action="UpdatePersonController?cmd=update2" method="post">

<input type="hidden" name="idPerson" value="${person.idPerson}">
<br/>

Name: <input type="text" name="namePerson" value="${person.namePerson}">

<br/>

<input type="hidden" name="idAddress" value="${person.address.idAddress}">

Street: <input type="text" name="streetAddress" value="${person.address.streetAddress}">

<br/>

Number: <input type="text" name="numberAddress" value="${person.address.numberAddress}">

<br/>

Dictrict: <input type="text" name="districtAddress" value="${person.address.districtAddress}">

<br/>
<br/>

<input type="submit" value="Update">

</form>

<br/>
<br/>

<a href="index.jsp">Back to Index</a>
<br/>
<a href="RetrievePersonController">Retrieve Persons</a>


</body>
</html>