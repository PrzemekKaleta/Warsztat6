<%--
  Created by IntelliJ IDEA.
  User: przemo
  Date: 07.07.19
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>index</title>
</head>
<body>
<h1>HOME PAGE</h1>

<a href="user/logout">Wyloguj</a><br>
<a href="user/mytweets">Moje Tweet'y</a><br>

<form:form method="POST" modelAttribute="tweet">
    Stwórz Tweet: <form:textarea path="text" maxlength="140" style="width:70%"/><br>
    <form:errors path="text" cssClass="error"/><br>

    <input type="submit" value="Dodaj">
</form:form>

<br>
<table style="width:80%" border="solid">
    <tr>
        <th>Utworzono</th>
        <th>Tweet</th>
        <th>Użytkownik</th>
    </tr>
    <c:forEach items="${allTweets}" var="myTweet">
        <tr>
            <td>${myTweet.created.toLocalDate()}</td>
            <td><a href="tweet/${myTweet.id}">${myTweet.text}</a></td>
            <td>${myTweet.user.firstName} ${myTweet.user.lastName}</td>
        </tr>
    </c:forEach>
</table>



<br>



</body>
</html>
