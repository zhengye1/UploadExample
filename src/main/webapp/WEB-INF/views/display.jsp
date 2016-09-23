<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Upload File Request Page</title>
</head>
<body>
	<c:choose>
		<c:when test="${filename  == 'images'}">
			<img src="<c:url value='/static/images/${filename }.jpg' />"></img>
		</c:when>
		<c:otherwise>
			<img src="<c:url value='/static/images/${filename }.png' />"></img>
		</c:otherwise>
	</c:choose>
</body>
</html>