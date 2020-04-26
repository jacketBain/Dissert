<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Проигрыватель</title>
    <link rel="stylesheet" type="text/css" href="resources/css/mainStyle.css">
    <script src="resources/js/playerScript.js"></script>
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
    <div class="player">
        <table>
            <tbody>
            <tr id="infoTrack">
                <td rowspan="3"><img src="resources/img/cassette.png" width="64" height="64"></td>
                <td class="player-tags"><p id="title" style="margin: 1px"></p></td>
                <td rowspan="3"><img src="resources/img/playerPlay.png" id="play"></img></td>
                <td rowspan="3"><img src="resources/img/playerPause.png" id="pause"></img></td>
                <td rowspan="3" class="player-time"><p id="currTime">00:00</p></td>
                <td rowspan="3" id="progress_td">
                    <progress class="progress" value='0' max='100' id='progress_play'></progress>
                </td>
                <td rowspan="3"  class="player-time"><p id="duration">10:00</p></td>
            </tr>
            <tr>
                <td class="player-tags"><p id="album" style="margin: 1px"></p></td>
            </tr>
            <tr>
                <td class="player-tags"><p id="artist" style="margin: 1px"></p></td>
            </tr>
            </tbody>
        </table>
        <%--<table>
            <tr id="infoTrack">
                <td>
                    <img src="resources/img/cassette.png" width="64" height="64">
                </td>
                <td class="player-tags">
                    <p id="title" style="margin: 1px"></p>
                    <hr>
                    <p id="album" style="margin: 1px"></p>
                    <hr>
                    <p id="artist" style="margin: 1px"></p>
                </td>
                <td>
                    <img src="resources/img/playerPlay.png" id="play"></img>
                </td>
                <td>
                    <img src="resources/img/playerPause.png" id="pause"></img>
                </td>
                <td class="player-time">
                    <p id="currTime">00:00</p>
                </td>
                <td id="progress_td">
                    <progress class="progress" value='0' max='100' id='progress_play'></progress>
                </td>
                <td class="player-time">
                    <p id="duration">10:00</p>
                </td>
            </tr>
        </table>--%>
    </div>
    <jsp:useBean id="listTracks" type="java.util.List<com.freemscp.model.Track>" scope="request"/>
        <c:forEach items="${listTracks}" var="listTracks">
            <div class="music_selector" onclick="addPlayer('${pageContext.request.contextPath}/player?id_playable=${listTracks.id}',
                '${listTracks.trackName}','${listTracks.id_album.albumName}','${listTracks.id_album.id_artist.artistName}','${listTracks.trackTime}')">
                <table>
                    <tr class="profile-avatar-text-music">
                        <td rowspan="3"><img src="resources/img/song.png" width="64" height="64"></td>
                        <td><img src="resources/img/track.png" width="16" height="16"></td>
                        <td>${listTracks.trackName}</td>
                        <td><img src="resources/img/genre.png" width="16" height="16"></td>
                        <td>${listTracks.id_album.id_genre.genreName}</td>
                    </tr>
                    <tr class="profile-avatar-text-music">
                        <td><img src="resources/img/album.png" width="16" height="16"></td>
                        <td>${listTracks.id_album.albumName}</td>
                        <td><img src="resources/img/year.png" width="16" height="16"></td>
                        <td>${listTracks.id_album.albumYear}</td>
                    </tr>
                    <tr class="profile-avatar-text-music">
                        <td><img src="resources/img/avatr.png" width="16" height="16"></td>
                        <td>${listTracks.id_album.id_artist.artistName}</td>
                        <td><img src="resources/img/noteKey.png" width="16" height="16"></td>
                        <td>${listTracks.id_keynote.keyNote}</td>
                    </tr>
                </table>
            </div>
        </c:forEach>


</body>
</html>
