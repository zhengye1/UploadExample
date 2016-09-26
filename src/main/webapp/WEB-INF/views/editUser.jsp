<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Edit User Form</title>
<!-- Bootstrap Core CSS -->
<link href="<c:url value='/static/css/bootstrap.min.css' />"
	rel="stylesheet">
</head>
<body>
	<div id="wrapper">
		<div class="form-group col-md-12">
			<div class="col-md-6">
				<form:form method="POST" modelAttribute="user" action="edit"
					class="userForm">
					<form:input type="hidden" path="id" id="id" />
					<div class="row">
						<div class="form-group col-md-6">
							<label class="col-md-2 user-control-label" for="firstName">First
								Name:</label>
							<div class="col-md-4">
								<form:input type="text" path="firstName" id="firstName" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-6">
							<label class="col-md-2 user-control-label" for="lastName">Last
								Name:</label>
							<div class="col-md-4">
								<form:input type="text" path="lastName" id="lastName" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-6">
							<label class="col-md-2 user-control-label" for="userName">Username:</label>
							<div class="col-md-4">
								<form:input type="text" path="username" id="username"
									disabled="true" />
							</div>
						</div>
					</div>
					<form:input type="hidden" path="hasProfileImage"
						id="hasProfileImage" />
					<div class="row">
						<div class="editFormButton">
							<input type="submit" value="Update" />
						</div>
					</div>
				</form:form>
			</div>
			<div class="col-md-6">
			<c:choose>
				<c:when test="${user.hasProfileImage eq 0}">
					<img src= "<c:url value='/static/images/default_user.png' />" />
				</c:when>
				<c:otherwise>
					User.hasProfileImage didn't pass + ${user.hasProfileImage }
				</c:otherwise>
			</c:choose>
			<%@include file="upload.jsp"%></div>
		</div>
	</div>
</body>
</html>