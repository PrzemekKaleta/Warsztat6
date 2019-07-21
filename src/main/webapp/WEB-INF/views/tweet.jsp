<%--
  Created by IntelliJ IDEA.
  User: przemo
  Date: 17.07.19
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Tweet</title>
</head>
<body>
<h1>TWEET DESCRIPTION PAGE</h1>

<p>Data powstania:
${tweet.created.toLocalDate()}</p>
<p>Godzina powstania:
${tweet.created.toLocalTime()}</p>
<p>Wpis Tweet'a:
${tweet.text}</p>
<p>Autor:
${tweet.user.firstName} ${tweet.user.lastName}</p>

Stwórz komentarz:
<form:form method="POST" modelAttribute="comment">
    <form:textarea path="text" maxlength="60" style="width:50%"/><br>
    <form:errors path="text" cssClass="error"/><br>

    <input type="submit" value="Dodaj">
</form:form>

Komentarze:
<table style="width:80%" border="solid">
    <tr>
        <th>Utworzono</th>
        <th>Komentarz</th>
        <th>Użytkownik</th>
    </tr>
    <c:forEach items="${allComments}" var="simpleComment">
        <tr>
            <td>${simpleComment.created.toLocalDate()}</td>
            <td><a href="tweet/${simpleComment.id}">${simpleComment.text}</a></td>
            <td>${simpleComment.user.firstName} ${simpleComment.user.lastName}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
