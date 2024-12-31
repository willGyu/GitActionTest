<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

	${item } <hr>
	
	req : ${requestScope.item } <hr>
	ses : ${sessionScope.item } <hr>
	
	req Scope : ${requestScope } <hr>
	ses Scope : ${sessionScope } <hr>
	
	${user }
	
</body>
</html>
