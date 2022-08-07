<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fform" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Form</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
	<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM-Customer Relationship Manager</h2>
		</div>
		<div id="container">
			<h3>Save Customer</h3>
			<fform:form action="saveCustomer" modelAttribute="customer" method="POST">
			<!-- Need to associate this data with CustomerID, below line will send the old id of customer before editing to the backend -->
			<fform:hidden path="id"/>
				<table>
					<tbody>
						<tr>
							<td><label>First Name:</label></td>
							<td><fform:input path="first_name"/>
						</tr>
						<tr>
							<td><label>Last Name:</label></td>
							<td><fform:input path="last_name"/>
						</tr>
						<tr>
							<td><label>Email:</label></td>
							<td><fform:input path="email"/>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save"/></td>
						</tr>
					</tbody>
				</table>
			</fform:form>
			<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
			</p>
		</div>
	</div>
</body>
</html>