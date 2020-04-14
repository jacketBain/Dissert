<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Менджер работы с аудиотекой</title>
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
                    <th> <p class="headtext">Проигрыватель</p></th>
                    <th><a class="inline-link-3" href="${pageContext.request.contextPath}/profile">Вернуться на страницу профиля</a></th>
                </tr>
            </table>
        </div>
    </header>
    <div class="menu-button" onClick="location.href='${pageContext.request.contextPath}/managerAlbum'">
        <table>
            <tr>
                <th>
                    <img src="resources/img/album.png" width="64" height="64">
                </th>
                <th> <audio src> </audio></th>
            </tr>
        </table>
    </div>
</body>
</html>
