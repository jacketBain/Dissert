<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Регистрация</title>
    <link rel="stylesheet" type="text/css" href="resources/css/loginStyle.css">
</head>
<body background="resources/img/background.png">
    <div  align="center">
        <img src="resources/img/mainLogo.png" height="400" width="400">
    </div>
<div class="login-form" align="center">
    <form method="post" action="${pageContext.request.contextPath}/register">
        <p class="intext">Регистрация:</p>
        <input class="depth" type="text" required name="nameArtist" id="nameArtistInput" placeholder="Имя исполнителя">
        <input class="depth" type="text" required name="login" id="loginInput" placeholder="Логин">
        <c:if test="${state==2}">
            <p class="errorLogin">Пользователь с таким логином уже зарегестрирован</p>
        </c:if>
        <input class="depth" type="password" required name="password" id="passwordInput" placeholder="Пароль">
        <input class="depth" type="password" required name="password2" id="passwordRepeatInput" placeholder="Повторите пароль">
        <c:if test="${state==3}">
            <p class="errorLogin">Пароли не совпадают</p>
        </c:if>
        <c:if test="${state==4}">
            <p class="errorLogin">Ошибка регистрации!!!</p>
        </c:if>
        <button class="metro" type="submit">Регистрация</button>
    </form>
</div>
</body>
</html>