<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<h1>
    Пролог
</h1>
<div>
    <span>
        Ты стоишь в космическом порту и готов подняться на борт<br>
        своего корабля. Разве ты не об этом мечтал? Стать капитаном<br>
        галактического судна с экипажем, который будет совершать<br>
        подвиги под твоим командованием.<br>
        Так что вперед!<br>
    </span>
</div>
<hr>
<h1>
    Знакомство с экипажем
</h1>
<div>
        <span>
            Когда ты поднялся на борт корабля, тебя поприветствовала девушка с черной папкой в руках:<br>
            -Здравствуйте командир! Я Зинаида - ваша помощница. Видите? Там в углу пьет кофе<br>
            наш штурман - сержант Перегарный Шлейф, под штурвалом спит наш бортмеханик - Черный Богдан,<br>
            а фотографирует его Сергей Стальная Пятка - наш навигатор.
            А как обращаться к вам?
        </span>
    </div>
<hr>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label for="userEmail">Email:
        <input type="text" name="userEmail" id="userEmail" value="${param.email}" required>
    </label><br>
    <label for="userPassword" style="margin-left: -22px">Password:
        <input type="password" name="userPassword" id="userPassword" required>
    </label><br>
    <br>
<button type="submit" style="margin-left: 40px">Login</button>
    <a href="${pageContext.request.contextPath}/registration">
        <button type="button">Registration</button>
    </a>
    <c:if test="${param.error != null}">
        <div style="color: red">
            <span>Email or password is not correct</span>
        </div>
    </c:if>
</form>
</center>
</body>
</html>
