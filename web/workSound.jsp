<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Работа со звуком</title>
    <link rel="stylesheet" type="text/css" href="resources/css/mainStyle.css">
    <script src="/resources/js/soundScripts.js"></script>
</head>
<body background="resources/img/background.png">
    <header>
        <div class="head">
            <table>
                <tr>
                    <th>
                        <img src="resources/img/mixer.png" width="64" height="64">
                    </th>
                    <th> <p class="headtext">Работа со звуком</p></th>
                    <th><a class="inline-link-3" href="${pageContext.request.contextPath}/index.jsp">Вернуться в главное меню</a></th>
                    <th><a class="inline-link-3" href="${pageContext.request.contextPath}/logout">Выйти</a></th>
                </tr>
            </table>
        </div>
    </header>
    <div class="profile-avatar-chose-audio">
        <table>
            <tr>
                <td><img src="resources/img/track.png" width="32" height="32"></td>
                <td><p class="profile-avatar-text">Выбрать песню</p></td>
            </tr>
        </table>
        <hr>
        <button class="metro_mini" onclick="getAudio('${pageContext.request.contextPath}/player?id_playable=2')">Дать</button>
        <button class="metro_mini" onclick="playAudio()">Проиграть</button>
        <button class="metro_mini" onclick="stopAudio()">Остановить</button>
    </div>
    <div class="profile-avatar">
        <table>
            <tr>
                <td><img src="resources/img/eq.png" width="32" height="32"></td>
                <td><p class="profile-avatar-text">Фильтр</p></td>
            </tr>
        </table>
        <hr>
        <input type="range" class="rangeFreq"
               min="20" max="8000" oninput="setFreqFilter(this.valueAsNumber)"
               onchange="setFreqFilter(this.valueAsNumber)">
        <button class="metro_mini" onclick="startFilter()">Вкл</button>
        <button class="metro_mini" onclick="stopFilter()">Выкл</button>
    </div>
    <div class="profile-avatar">
        <table>
            <tr>
                <td><img src="resources/img/oscil.png" width="32" height="32"></td>
                <td><p class="profile-avatar-text">Генерация звуковой волны</p></td>
            </tr>
        </table>
        <hr>
        <input type="range" class="rangeFreq"
               min="0" max="1000" oninput="setFreqOscillatorSound(this.valueAsNumber)"
               onchange="setFreqOscillatorSound(this.valueAsNumber)"></td>
        <hr>
        <table>
            <tr>
                <td colspan="2">
                    <button class="metro_mini" onclick="setFreqOscillatorSound(261)">261 Гц (C)</button>
                    <button class="metro_mini" onclick="setFreqOscillatorSound(293)">293 Гц (D)</button>
                    <button class="metro_mini" onclick="setFreqOscillatorSound(329)">329 Гц (E)</button>
                    <button class="metro_mini" onclick="setFreqOscillatorSound(349)">349 Гц (F)</button>
                    <button class="metro_mini" onclick="setFreqOscillatorSound(392)">392 Гц (G)</button>
                    <button class="metro_mini" onclick="setFreqOscillatorSound(440)">440 Гц (A) Звук камертона</button>
                    <button class="metro_mini" onclick="setFreqOscillatorSound(493)">493 Гц (B)</button>
                </td>
            </tr>
            <tr>
                <td>
                    <button class="metro_mini" onclick="startOscillatorSound()">Включить</button>
                    <button class="metro_red_mini" onclick="stopOscillatorSound()">Выключить</button>
                </td>
                <td></td>
            </tr>
        </table>
    </div>
</body>
</html>
