<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 12.01.2020
  Time: 09:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/fragments/header.jsp"/>

<form action="/register" method="post">

    <h1>Rejestracja</h1>

    Nazwa użytkownika: <input type="text" name="username" value="${user.username}"><br/>
    Hasło: <input type="password" name="password" value="${user.password}"><br/>
    Imię: <input type="text" name="firstName" value="${user.firstName}"><br/>
    Nazwisko: <input type="text" name="lastName" value="${user.lastName}"><br/><br/>

    <input type="submit" name="Rejestruj">

    <c:if test="${error != null}">
        <p style="...">
                ${error}
        </p>
    </c:if>
</form>
<br/>


<footer>
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>
</body>
</html>
