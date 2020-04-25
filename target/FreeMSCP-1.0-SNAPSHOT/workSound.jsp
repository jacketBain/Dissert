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
        <button class="metro_mini" onclick="getAudio('/resources/03. Царь Горы.mp3')">Дать</button>
        <button class="metro_mini" onclick="playAudio()">Проиграть</button>
        <button class="metro_mini" onclick="stopAudio()">Остановить</button>
        <button class="metro_mini" onclick="pause()">Пауза</button>
        <button class="metro_mini" onclick="resume()">ПВернуть</button>
        <input type="number" id="bpm">
    </div>
    <div class="profile-avatar">
        <table>
            <tr>
                <td><img src="resources/img/dist.png" width="32" height="32"></td>
                <td><p class="profile-avatar-text">Дисторшн</p></td>
            </tr>
        </table>
        <hr>
        <table>
            <tr>
                <td colspan="3">
                    <input id="distAmountRange" type="range" class="rangeFreq"
                           min="0" max="400" oninput="setAmountDistortion(this.valueAsNumber)"
                           onchange="setAmountDistortion(this.valueAsNumber)">
                </td>
            </tr>
            <tr>
                <td><button id="startDist" disabled = true class="metro_mini" onclick="startDistortion()">Вкл</button></td>
                <td><button id="stopDist" disabled = true class="metro_red_mini" onclick="stopDistortion()">Выкл</button></td>
                <td><progress id="amountDist" class="dist_progress" value="0" max="100"></progress></td>
            </tr>
        </table>
    </div>
    <div class="profile-avatar">
        <table>
            <tr>
                <td><img src="resources/img/eq.png" width="32" height="32"></td>
                <td><p class="profile-avatar-text">Фильтр</p></td>
            </tr>
        </table>
        <hr>
        <table>
            <tr>
                <td colspan="5">
                    <input type="range" class="rangeFreq"
                                       min="0" max="1" step="0.001" oninput="setFreqFilter(this.valueAsNumber)"
                                       onchange="setFreqFilter(this.valueAsNumber)">
                </td>
            </tr>
            <tr>
                <td colspan="5">
                    <input type="range" class="rangeFreq"
                           min="0" max="10" step="0.01" oninput="setQFilter(this.valueAsNumber)"
                           onchange="setQFilter(this.valueAsNumber)">
                </td>
            </tr>
            <tr>
                <td><button id="startFilter" disabled = true class="metro_mini" onclick="startFilter()">Вкл</button></td>
                <td><button id="stopFilter" disabled = true class="metro_red_mini" onclick="stopFilter()">Выкл</button></td>
                <td><p id="freq"  class="display-work"> Частота </td>
                <td><p id="q"  class="display-work"> Добротность </td>
                <td><select class="display-work" name="albumGenre" size="1" onchange="setTypeFilter(this.value)">
                        <option>lowpass</option>
                        <option>highpass</option>
                </select></td>
            </tr>
        </table>
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
               min="0" max="8000" oninput="setFreqOscillatorSound(this.valueAsNumber)"
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
