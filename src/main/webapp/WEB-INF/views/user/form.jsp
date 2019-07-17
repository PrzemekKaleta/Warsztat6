
<%--
  Created by IntelliJ IDEA.
  User: przemo
  Date: 07.07.19
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>form user</title>
</head>
<body>
<h1>USER FORM PAGE</h1>
<form:form method="POST" modelAttribute="user">
    E-mail: <form:input path="email"/><br>
    <form:errors path="email" cssClass="error"/><br>
    Hasło: <form:password path="password"/><br>
    <form:errors path="password" cssClass="error"/><br>
    Imie: <form:input path="firstName"/><br>
    <form:errors path="firstName" cssClass="error"/><br>
    Nazwisko: <form:input path="lastName"/><br>
    <form:errors path="lastName" cssClass="error"/><br>
    <input type="submit" value="Zarejestruj">
</form:form>
<br>
<a href="login">Zaloguj</a>
</body>
</html>
