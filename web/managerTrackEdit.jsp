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
                        <img src="resources/img/track.png" width="64" height="64">
                    </th>
                    <th> <p class="headtext">Треки</p></th>
                    <th><a class="inline-link-3" href="${pageContext.request.contextPath}/manager.jsp">Вернуться в меню менеджера</a></th>
                    <th><a class="inline-link-3" href="${pageContext.request.contextPath}/managerTrack">Отменить изменения и вернуться назад</a></th>
                </tr>
            </table>
        </div>
    </header>

    <div align="center">
    <form id="changeTrack" method="post" action="${pageContext.request.contextPath}/managerTrack?action=change">
        <p class="profile-avatar-text">Изменение трека</p>
        <div>
            <jsp:useBean id="listAlbums" type="java.util.List<com.freemscp.model.Album>" scope="request"/>
            <jsp:useBean id="listKeys" type="java.util.List<com.freemscp.model.KeyNote>" scope="request"/>
            <table class="profile-avatar">
                <tbody>
                <tr class="profile-avatar-text">
                <td>Идентификатор трека : </td>
                <td><input name="trackID" hidden type="text" required value="${chTrackID}">
                    ${chTrackID}
                </td>
                </tr>
                <tr class="profile-avatar-text">
                    <td>Название трека : </td>
                    <td><input class="depth" name="trackName" type="text" required value="${chTrackName}"></td>
                </tr>
                <tr class="profile-avatar-text">
                    <td>Альбом : </td>
                    <td>
                        <select class="profile-avatar-text" name="trackAlbum" size="1">
                            <c:forEach items="${listAlbums}" var="listAlbums">
                                <option>${listAlbums.albumName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr class="profile-avatar-text">
                    <td>BPM : </td>
                    <td><input class="depth" name="trackBPM" type="number" required value="${chTrackBPM}"></td>
                </tr>
                <tr class="profile-avatar-text">
                    <td>Тональность : </td>
                    <td>
                        <select class="profile-avatar-text" name="trackKeyNote" size="1">
                            <c:forEach items="${listKeys}" var="listGenres">
                                <option>${listGenres.keyNote}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                </tbody>
            </table>
            <button class="metro">Изменить</button>
            <button class="metro_red" type="button" onclick="location.href='${pageContext.request.contextPath}/managerTrack?id_ch=${chTrackID}&action=del'">Удалить</button>
        </div>
    </form>
    </div>
</body>
</html>
