<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<c:forEach var="iata" items="${iataList}">
		${iata.value.name }<br>
		<a href="icao?icao=${iata.value.icao }">${iata.value.name }</a>
	</c:forEach>
</body>
</html>
