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
                    <th><a class="inline-link-3" href="${pageContext.request.contextPath}/managerAlbum">Отменить изменения и вернуться назад</a></th>
                </tr>
            </table>
        </div>
    </header>

    <div align="center">
    <form id="addAlbum" method="post" action="${pageContext.request.contextPath}/managerAlbum?action=add">
        <p class="profile-avatar-text">Добавление альбома</p>
        <div>
            <jsp:useBean id="listGenres" type="java.util.List<com.freemscp.model.Genre>" scope="request"/>

            <table class="profile-avatar">
                <tbody>
                <tr class="profile-avatar-text">
                    <td>Название альбома : </td>
                    <td><input class="depth" name="albumName" type="text" required value="Введите название"></td>
                </tr>
                <tr class="profile-avatar-text">
                    <td>Жанр : </td>
                    <td>
                        <select class="profile-avatar-text" name="albumGenre" size="1">
                            <c:forEach items="${listGenres}" var="listGenres">
                                <option>${listGenres.genreName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                </tbody>
            </table>
            <button class="metro" type="submit">Добавить</button>
        </div>
    </form>
    </div>
</body>
</html>
