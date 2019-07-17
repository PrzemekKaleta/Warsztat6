<%--
  Created by IntelliJ IDEA.
  User: przemo
  Date: 17.07.19
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

</body>
</html>
