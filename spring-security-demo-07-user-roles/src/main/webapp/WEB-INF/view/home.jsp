<%@ taglib prefix="fform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kush Company Home Page</title>
</head>
<body>
<h2>Kushal Company Home Page</h2>
<hr>
<p>
Welome to our Home Page
</p>
<p>
	User: <security:authentication property="principal.username"/>
	<br>
	User Role: <security:authentication property="principal.authorities"/>
</p>

<!-- Add links to /leaders for Managers -->
<p>
	<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a> (Only for Managers)
</p>
<p>
	<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a> (Only for Systems)
</p>

<fform:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout" />
</fform:form> 
</body>
</html>