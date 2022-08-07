<%@ taglib prefix="fform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<style>
		.failed {
			color: red;
		}
</style>
	
</head>
<body>
<h3>My Custom Login Page</h3>
	
	<fform:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST" >
		<!-- Checking for errors -->
		<c:if test="${param.error != null}">
			<i class="failed">Sorry! Invalid Username/Password Detected</i>
		</c:if>
		<p>
			UserName: <input type="text" name="username" />
		</p>
		<p>
			Password: <input type="password" name="password" />
		</p>
		<input type="submit" value="Login" />
	</fform:form>
</body>
</html>