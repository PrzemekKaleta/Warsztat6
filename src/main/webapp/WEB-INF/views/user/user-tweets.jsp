<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: przemo
  Date: 17.07.19
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User tweets</title>
</head>
<body>
<h1>USER TWEETS PAGE</h1>

<table style="width:80%" border="solid">
    <tr>
        <td>Data</td>
        <td>Tweet</td>
    </tr>
    <c:forEach items="${mytweets}" var="myTweet">
        <tr>
            <td>${myTweet.created.toLocalDate()}</td>
            <td><a href="/tweet/${myTweet.id}">${myTweet.text}</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
