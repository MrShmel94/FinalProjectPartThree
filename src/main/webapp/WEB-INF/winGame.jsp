<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Your Adventure</title>
</head>
<body>
<%@include file="header.jsp"%>
<center>
<div>
    <span>
        Ты рассказал правду и тебе повезло, ведь он все знал, он поверил тебе. Капитан<br>
        помог восстановить твою память, он тебе рассказал как ты сюда попал и то, что ты тоже<br>
        от части капитан корабля и в правду память начала приходить, ты начал вспоминать<br>
        что у тебя была команда.<br>
        -"Но где же моя команда..!? Я точно помню у меня была команда"-<br>
        -"Хахах, не беспокойся, с ними все в порядке, они в отсеке с нашим медиком"-<br>
    </span>
    <hr>

    <span>
        Вы отлично пообщались, капитан помог починить вам корабль и с целой командой попасть домой.<br>
        Вот и подошло ваше путешествие к концу, очень хорошо, что все отлично завершилось.<br>
        Надеюсь мы снова увидимся с тобой, капитан звездного корабля - ${sessionScope.user.name}<br>
    </span>
    <hr>

    <span>
        Хотите вы совершить ещё одно путешествия в эту незабываемую историю!? Или с вас хватит!? :)
    </span>
    <hr>
</div>
        <a href="${pageContext.request.contextPath}/start">
            <button type="button" style="margin-right: 200px">Принять</button>
        </a>
    <a href="${pageContext.request.contextPath}/logout">
        <button type="button">Отказаться</button>
    </a>
</center>
</body>
</html>