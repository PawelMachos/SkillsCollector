<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 12.01.2020
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User skills</title>
</head>
<body>
<h1>Twoje umiejętności</h1>

<table width="500" cellspacing="10">
    <thead>
    <tr>
        <th>Lp.</th>
        <th>Nazwa umiejętności</th>
        <th>Poziom umiejętności</th>
    </tr>

        <c:forEach items="${skills}" var="skill" varStatus="Lp">
    <tr>
            <td>${Lp.count}</td>
            <td>${skill.name}</td>
            <td>${sources.attachedSkills.count}</td>
    </tr>
        </c:forEach>
    </thead>

</table>

Umiejetnosci: ${skills}
</body>
</html>