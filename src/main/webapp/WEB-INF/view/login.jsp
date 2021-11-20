<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/style.css" rel="stylesheet">
</head>
<body>
<div class = "page">
	<div id = "login-center">
		<form method="post" action="<c:url value="/login"/>">
		    <div class = "login"><label> User Name : <input type="text" name="username"/> </label></div>
		    <div class = "login"><label> Password: <input type="password" name="password"/> </label></div>
		    <div class = "login"><input id = "login-button" type="submit" value="Sign In"/></div>
		    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
	</div>	
</div>
</body>
</html>
