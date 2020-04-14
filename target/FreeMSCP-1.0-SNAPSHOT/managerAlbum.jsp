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
    <!-- Модальное окно изменения
    <div id="changeModal" class="modalbackground">
        <div class="modalwindow">
            <h3>Изменение данных альбома</h3>
            <p>${chAlbum}</p>
            <a href="${pageContext.request.contextPath}/managerAlbum">Закрыть</a>
        </div>
    </div> -->
    <div align="center">
    <jsp:useBean id="listAlbums" type="java.util.List<com.freemscp.model.Album>" scope="request"/>
    <table>
        <tr class="profile-avatar">
            <td class="profile-avatar-text">Название альбома</td>
            <td class="profile-avatar-text">Год публикации</td>
            <td class="profile-avatar-text">Жанр</td>
            <td class="profile-avatar-text"></td>
        </tr>

        <c:forEach items="${listAlbums}" var="listAlbums">
            <tr class="profile-avatar">
                <td class="profile-avatar-text">${listAlbums.albumName}</td>
                <td class="profile-avatar-text">${listAlbums.albumYear}</td>
                <td class="profile-avatar-text">${listAlbums.id_genre.genreName}</td>
                <td class="profile-avatar-text"><a href="${pageContext.request.contextPath}/managerAlbum?id_ch=${listAlbums.id}&action=chg">Изменить</a></td>
            </tr></tr>
        </c:forEach>
        <tr class="profile-avatar">
            <td colspan="4" align="center" class="profile-avatar-text"><a href="${pageContext.request.contextPath}/managerAlbum?action=add">Добавить...</a></td>
        </tr>
    </table>
    </div>
</body>
</html>
