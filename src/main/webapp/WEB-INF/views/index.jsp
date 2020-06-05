<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Employee List</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h3>employees [add new]</h3>
<c:if test="${!empty listPersons}">
	<table class="tg">
	<tr>
		<th width="80">id</th>
		<th width="120">name</th>
		<th width="120">primary address</th>
		<th width="120">primary contact info</th>
		<th width="60">age</th>
		<th width="60"># years rendered</th>
		<th width="60"></th>
	</tr>
	<c:forEach items="${listPersons}" var="person">
		<tr>
			<td>${employee.id}</td>
			<td>${employee.first_name} ${employee.middle_name} ${employee.last_name}</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><a href="<c:url value='/edit/${person.id}' />" >[Edit]</a>
				<a href="<c:url value='/remove/${person.id}' />" >[Delete]</a></td>
			<td></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
