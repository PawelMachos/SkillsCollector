<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 12.01.2020
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/fragments/header.jsp"/>

<h1>Logowanie</h1>

<form action="/login" method="post">
    Username: <input type="text" name="username" required><br/>
    Hasło: <input type="password" name="password" required><br/>
    <c:if test="${error != null}">
        <p style="...">
                ${error}
        </p>
    </c:if>
    <input type="submit" name="Loguj"> <input type="reset" value="Wyczyść"/>
</form>


</body>
</html>