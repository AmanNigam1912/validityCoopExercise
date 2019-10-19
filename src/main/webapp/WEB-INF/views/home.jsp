<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Validity!!  
	</h1>

	<!--Dispaly Potential duplicates-->
	<h2>Potential duplicates</h2>
	<c:set var="count" value="0"/>
	<c:forEach items="${map}" var="entry">		
		<c:choose>
			<c:when test="${entry.getValue().size() > 0}">
				<c:set var="count" value="${count + 1}"/>
				${entry.getKey().getId()},${entry.getKey().getFirst_name()},${entry.getKey().getLast_name()},
				${entry.getKey().getCompany()},${entry.getKey().getEmail()},
				${entry.getKey().getAddress1()},${entry.getKey().getAddress2()},
				${entry.getKey().getZip()},${entry.getKey().getCity()},
				${entry.getKey().getState_long()},${entry.getKey().getState()},
				${entry.getKey().getPhone()}<br />
			</c:when>
		</c:choose>
	</c:forEach>
	
	<br/>
	<!--Dispaly None duplicates-->
	<h2>None duplicates</h2>
	<c:set var="count1" value="0" />
	<c:forEach items="${map}" var="entry">
		<c:choose>
			<c:when test="${entry.getValue().size() == 0}">
				<c:set var="count1" value="${count1 + 1}"/>
				${entry.getKey().getId()},${entry.getKey().getFirst_name()},${entry.getKey().getLast_name()},
				${entry.getKey().getCompany()},${entry.getKey().getEmail()},
				${entry.getKey().getAddress1()},${entry.getKey().getAddress2()},
				${entry.getKey().getZip()},${entry.getKey().getCity()},
				${entry.getKey().getState_long()},${entry.getKey().getState()},
				${entry.getKey().getPhone()}<br />
			</c:when>
		</c:choose>
	</c:forEach>
</body>
</html>
