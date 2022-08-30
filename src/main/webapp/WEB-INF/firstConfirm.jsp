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
        Вы с опасением принимаете вызов подняться на их корабль, головная боль не даёт покоя..Вы не можете ничего вспомнить.<br>
        Поднимаетесь по ступенькам, видите перед собой двух существ с оружием на перевес, видно, что они настроены не дружелюбно.<br>
        Они стоят прямо перед мостиком капитана. Вы видите за их спинами сидит какой-то огромный человек, и взмахам руки<br>
        приказывает охранникам пропустить вас. Они расступаются перед вами и у вас открывается дорога до мостика капитана.<br>
        Вы снова в раздумываниях, "что случилось", "кто я", "где я и кто эти "люди"". Человек напротив вас, смотрит на вас<br>
        не дружеским взглядом, перед вами ещё один выбор... Подняться на мостик к капитану и попытаться договориться либо <br>
        попробовать сбежать!? А вдруг получится.<br>
    </span>
    <hr>
</div>
    <form action="${pageContext.request.contextPath}/start" method="post">
        <button type="submit" value="secondConfirm" name="confirm" style="margin-right: 200px">Принять</button>
        <button type="submit" name="reject" >Отклонить</button>
    </form>
</center>
</body>
</html>