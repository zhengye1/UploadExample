<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Upload File Request Page</title>
<style>
#error {
	color: red;
}
</style>
</head>
<body>
	<form method="POST" action="upload" enctype="multipart/form-data">
		<c:if test="${param.success eq false}">
			<div id="error">
				<strong id="error">Upload Failed!!! + ${errorMsg }</strong>
			</div>
		</c:if>
		<label>File to upload: </label> <input type="file" name="imageFile" />
		<input type="hidden" name="filename" value="${user.username }"><br>
		<input type="submit" name="upload" value="Upload" />
		<input type="submit" name="remove" value="Remove" />
	</form>
</body>
</html>