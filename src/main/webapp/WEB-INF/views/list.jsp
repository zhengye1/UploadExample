<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>List of Users</title>
</head>
<body>
	<div id="wrapper">
		<div class="row">
			<div class="table-responsive">
				<table class="table table-striped table-bordered table-hover"
					id="userTable">
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Username</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${users}" var="user">
							<tr>
								<td>${user.firstName}</td>
								<td>${user.lastName}</td>
								<td>${user.username}</td>
								<td>View</td>
								<td><a href="${contextPath}/user/${user.username}/edit">Edit</a></td>
								<td>Delete</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- /.table-responsive -->
		</div>
	</div>
</body>
</html>