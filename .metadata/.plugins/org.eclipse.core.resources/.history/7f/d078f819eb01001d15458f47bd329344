<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="ff" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Reg. Form</title>
<style>
.errorss {color:red}
</style>
</head>
<body>
fill the form
<ff:form action="processForm" modelAttribute="customer">
FirstName = <ff:input path="firstName" />
		<br>
		<hr>
LastName (*) = <ff:input path="lastName" />
	<ff:errors path="lastName" cssClass="errorss" />
		<br>
		<hr>
FreePasses = <ff:input path="freePasses" />
	<ff:errors path="freePasses" cssClass="errorss" />	
		<br>
		<hr>
PostalCode = <ff:input path="postalCode" />
	<ff:errors path="postalCode" cssClass="errorss" />	
		<br>
		<hr>
CourseCode = <ff:input path="courseCode" />
	<ff:errors path="courseCode" cssClass="errorss" />	
		<br>
		<hr>
<input type="submit" value="submit"/>	

</ff:form>
</body>
</html>