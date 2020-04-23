<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Проигрыватель</title>
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
                    <th><a class="inline-link-3" href="${pageContext.request.contextPath}/index.jsp">Вернуться в главное меню</a></th>
                </tr>
            </table>
        </div>
    </header>
    <jsp:useBean id="listTracks" type="java.util.List<com.freemscp.model.Track>" scope="request"/>
        <c:forEach items="${listTracks}" var="listTracks">
            <div class="profile-avatar">
                <table>
                    <tr class="profile-avatar-text">
                        <td rowspan="3"><img src="resources/img/song.png" width="128" height="128"></td>
                        <td><img src="resources/img/track.png" width="32" height="32"></td>
                        <td>${listTracks.trackName}</td>
                        <td><img src="resources/img/genre.png" width="32" height="32"></td>
                        <td>${listTracks.id_album.id_genre.genreName}</td>
                        <td rowspan="3"><audio src="${pageContext.request.contextPath}/player?id_playable=${listTracks.id}" controls="controls"></audio></td>
                    </tr>
                    <tr class="profile-avatar-text">
                        <td><img src="resources/img/album.png" width="32" height="32"></td>
                        <td>${listTracks.id_album.albumName}</td>
                        <td><img src="resources/img/year.png" width="32" height="32"></td>
                        <td>${listTracks.id_album.albumYear}</td>
                    </tr>
                    <tr class="profile-avatar-text">
                        <td><img src="resources/img/avatr.png" width="32" height="32"></td>
                        <td>${listTracks.id_album.id_artist.artistName}</td>
                        <td><img src="resources/img/noteKey.png" width="32" height="32"></td>
                        <td>${listTracks.id_keynote.keyNote}</td>
                    </tr>
                </table>
            </div>
        </c:forEach>
    
    
    
</body>
</html>
