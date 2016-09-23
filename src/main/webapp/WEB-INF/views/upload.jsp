<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Upload File Request Page</title>
</head>
<body>
	<c:if test="${param.success eq false}">
		<p>
			<strong id="Error" color="red">Upload Failed!!!</strong>
		</p>
	</c:if>
	<form method="POST" action="upload" enctype="multipart/form-data">
		<label>File to upload: </label>
		<input type="file" name="imageFile" /> <br>
		<label>Filename:</label>
		<input type="text" name="filename"><br>
		<input
			type="submit" value="Upload" /> Press Upload to upload the file!
	</form>
</body>
</html>