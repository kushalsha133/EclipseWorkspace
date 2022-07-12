<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Confirmation</title>
</head>
<body>
	the student is confirmed:${student.firstName} ${student.lastName}
	<hr>
	Country=${student.country } favLanguage= ${student.favLang }
	<br>
	operating systems
	<ul>
		<c:forEach var="temp" items="${student.operatingSystems}">
			<li> ${temp }</li>
		</c:forEach>
	</ul>
</body>
</html>