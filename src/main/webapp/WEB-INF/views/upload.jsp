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
		<br> <label>Filename:</label> <input type="text" name="filename"><br>
		<input type="submit" value="Upload" />
	</form>
</body>
</html>