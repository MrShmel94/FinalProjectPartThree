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
        -"Кто ты? И что ты тут забыл?"- Спросил капитан незнакомого тебе корабля.<br>
        Ты в раздумываниях, пытаешься напрячь память, но она тебе не поддаётся,<br>
        ты из-за всех сил пытаешься вспомнить кто ты...<br>
        "Может попытать солгать? Сказать грозным голосом, что ты захватчик планет<br>
        и с тобой шутки плохи, за тобой летит целая армия головорезов", а вдруг получится?<br>
        Он испугается и отпустит тебя... Либо взять и рассказать правду, хотя какую? <br>
        Получается банально сказать что ты потерял память... Ведь ты и не врешь.<br>
    </span>
    <hr>
</div>
    <form action="${pageContext.request.contextPath}/start" method="post">
        <button type="submit" value="thirdConfirm" name="confirm" style="margin-right: 200px">Рассказать правду</button>
        <button type="submit" name="reject" >Солгать</button>
    </form>
</center>
</body>
</html>