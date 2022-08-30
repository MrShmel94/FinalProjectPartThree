<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<form action="${pageContext.request.contextPath}/registration" method="post">
    <label for="userName">Name:
        <input type="text" name="userName" id="userName" required><br><br>
    </label>

    <label for="userEmail">Email:
        <input type="text" name="userEmail" id="userEmail" required><br><br>
    </label>
    <label for="userPassword" style="margin-left: -22px">Password:
        <input type="password" name="userPassword" id="userPassword" required><br><br>
    </label>
    <button type="submit" style="margin-left: 35px">Registration</button>
    <c:if test="${not empty requestScope.errors}">
        <div style="color: red">
            <c:forEach var="error" items="${requestScope.errors}">
                <span>${error.message}</span><br>
            </c:forEach>
        </div>
    </c:if>
</form>
</center>
</body>
</html>
