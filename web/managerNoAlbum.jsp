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
                        <img src="resources/img/album.png" width="64" height="64">
                    </th>
                    <th> <p class="headtext">${id_ch}</p></th>
                    <th><a class="inline-link-3" href="${pageContext.request.contextPath}/manager.jsp">Вернуться в меню менеджера</a></th>
                </tr>
            </table>
        </div>
    </header>

    <div align="center">
        <form class="profile-avatar">
            <img src="resources/img/alert.png" width="128" height="128">
            </img>
            <p class="profile-avatar-text">У вас нет альбомов</p>
            <p class="profile-avatar-text">Как начинающему музыканту вам необхоимо создать первый альбом, что бы добавлять в него свои треки</p>
            <button class="metro" type="button" onclick="location.href='${pageContext.request.contextPath}/managerAlbum?&action=add'">Создать альбом</button>
        </form>
    </div>
</body>
</html>
