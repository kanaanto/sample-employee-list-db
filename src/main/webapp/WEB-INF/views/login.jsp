<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet">
<link href="<c:url value='/resources/css/login.css' />" rel="stylesheet">
</head>
	<body class="text-center">
		<form class="form-signin" name="f" action="<c:url value='j_spring_security_check'/>"
					method="POST">
			<table>
				<tr>
					<td>Username:</td>
					<td><input type='text' name='j_username'  class="form-control" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='j_password'  class="form-control" ></td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"  class="btn btn-lg btn-primary btn-block"></td>
				</tr>
			</table>
		</form>
	</body>
</html>