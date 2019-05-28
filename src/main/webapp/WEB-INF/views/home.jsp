<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<c:forEach var="iata" items="${iataList}">
		<a href="icao?icao=${iata.value.icao }">${iata.value.name }</a><br>
	</c:forEach>
</body>
</html>
