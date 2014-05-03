<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Person</title>
</head>


<body>

<h2>Create Person</h2>

<form action="CreatePersonController" method="post">

Name: <input type="text" name="namePerson">

<br/>

Street: <input type="text" name="streetAddress">

<br/>

Number: <input type="text" name="numberAddress">

<br/>

Dictrict: <input type="text" name="districtAddress">

<br/>
<br/>

<input type="submit" value="Create">

</form>

<br/>
<br/>

<a href="index.jsp">Back to Index</a>
<br/>
<a href="RetrievePersonController">Retrieve Persons</a>

</body>


</html>