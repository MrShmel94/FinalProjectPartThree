<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty sessionScope.user}">
        <form action="${pageContext.request.contextPath}/logout" method="get">
            <div>
                <span style="color: blue">Name: ${sessionScope.user.name}</span><br>
                <button type="submit" style="margin-left: 97%; margin-top:1%">Logout</button>
                <span style="color: green">Win Game: ${sessionScope.user.winGame}</span><br>
                <span style="color: red">Lose Game: ${sessionScope.user.loseGame}</span><br>
            </div>
        </form>
    <hr>
    <h1>
        Your Adventure
    </h1>
    <hr>
</c:if>
