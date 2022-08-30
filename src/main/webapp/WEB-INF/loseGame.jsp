<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Lose Game</title>
</head>
<body>
<%@include file="header.jsp"%>
<center>
    <h1>
        You Dead
    </h1>
<span>
    Очень печально.... Ты просто оказался не удачлив, либо не понял намекав судьбы..<br>
    жать, но твой путь капитана космического корабля, который бороздит вселенную <br>
    так глупо подошел к концу... Но не нужно отчаиваться, ведь это игра и у всех<br>
    должен быть второй шанс. Ну что попробуем схватить удачу за хвост ещё раз!?<br>
</span>
    <hr>
    <a href="${pageContext.request.contextPath}/start">
        <button type="button" style="margin-right: 200px">Принять</button>
    </a>
    <a href="${pageContext.request.contextPath}/logout">
        <button type="button">Отказаться</button>
    </a>
</center>
</body>
</html>
