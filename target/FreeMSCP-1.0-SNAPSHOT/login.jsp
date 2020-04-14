<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Авторизация</title>
    <link rel="stylesheet" type="text/css" href="resources/css/loginStyle.css">
</head>
<body background="resources/img/background.png">
    <div  align="center">
        <img src="resources/img/mainLogo.png" height="400" width="400">
    </div>
<div class="login-form" align="center">
    <form method="post" action="${pageContext.request.contextPath}/">
        <p class="intext">Вход в систему:</p>
        <input class="depth" type="text" required name="login" id="loginInput" placeholder="Логин">
        <input class="depth" type="password" required name="password" id="passwordInput" placeholder="Пароль">
        <button class="metro" type="submit">Войти</button>
        <c:if test="${state==1}">
            <p class="errorLogin">Данного музыканта нет в системе</p>
        </c:if>
        <p>Если вы не зарегестрированы, перейдите по ссылке <a class="inline-link-3" href="${pageContext.request.contextPath}/register">Регистрация</a></p>
    </form>
</div>
</body>
</html>