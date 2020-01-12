<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalTime" %><%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 12.01.2020
  Time: 09:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
<span>
    Paweł Machoś
</span>&nbsp;
<span>Rok: <%= LocalDate.now().getYear() %> <%=LocalTime.now()%></span>
</div>