<%--
  Created by IntelliJ IDEA.
  User: przemo
  Date: 07.07.19
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h1>LOGIN PAGE</h1>
<form:form method="POST" modelAttribute="loginUser">
    E-mail: <form:input path="email"/><br>
    Hasło: <form:password path="password"/><br>
    <form:errors path="*" cssClass="error"/><br>
    <input type="submit" value="Zaloguj">
</form:form>
<br>
<a href="register">Zarejestruj</a>
</body>
</html>
