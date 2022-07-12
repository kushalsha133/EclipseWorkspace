<%@ taglib prefix="ff" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Student Registration form</title>
</head>
<body>
	<ff:form action="processForm" modelAttribute="student">
FirstName = <ff:input path="firstName" />
		<br>
		<hr>
LastName = <ff:input path="lastName" />
		<br>
		<hr>
Country: 
		<ff:select path="country">
		<ff:options items="${theCountryOptions }"/>
		</ff:select>		
		<br>
		<hr>
		Java <ff:radiobutton path="favLang" value="Java"/>
		C# <ff:radiobutton path="favLang" value="csharp"/>
		Python <ff:radiobutton path="favLang" value="snake"/>
		<br>
		<hr>
		Operating Systems:
		Linux <ff:checkbox path="operatingSystems" value="Linux"/>
		Mac <ff:checkbox path="operatingSystems" value="Mac"/>
		Windows <ff:checkbox path="operatingSystems" value="Windows"/>
		<input type="submit" value="Submit" />
	</ff:form>
</body>
</html>