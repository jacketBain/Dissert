<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Музыкальный сервис</title>
    <link rel="stylesheet" type="text/css" href="resources/css/mainStyle.css">
</head>
<body background="resources/img/background.png">
    <header>
        <div class="head">
            <table>
                <tr>
                    <th>
                        <img src="resources/img/main.png" width="64" height="64">
                    </th>
                    <th> <p class="headtext">Музыкант : ${name}</p></th>
                    <th><a class="inline-link-3" href="${pageContext.request.contextPath}/logout">Выйти</a></th>
                </tr>
            </table>
        </div>
    </header>
    <div class="menu-button" onClick="location.href='${pageContext.request.contextPath}/profile'">
        <table>
            <tr>
                <th>
                    <img src="resources/img/user.png" width="64" height="64">
                </th>
                <th> <p class="menu-button-text">Мой профиль</p></th>
            </tr>
        </table>
    </div>
    <div class="menu-button" onClick="location.href='${pageContext.request.contextPath}/playerTracks'">
        <table>
            <tr>
                <th>
                    <img src="resources/img/playmusic.png" width="64" height="64">
                </th>
                <th> <p class="menu-button-text">Слушать музыку</p></th>
            </tr>
        </table>
    </div>
    <div class="menu-button" onClick="location.href='${pageContext.request.contextPath}/workSound'">
        <table>
            <tr>
                <th>
                    <img src="resources/img/mixer.png" width="64" height="64">
                </th>
                <th> <p class="menu-button-text">Работа со звуком</p></th>
            </tr>
        </table>
    </div>
</body>
</html>
