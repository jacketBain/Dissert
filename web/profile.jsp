<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Мой профиль</title>
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
    <div align="center">
        <table>
            <tbody>
            <tr class="profile-avatar">
                <td rowspan="3"><img src="resources/img/avatr.png" width="256" height="256"></td>
                <td class="profile-avatar-text">Имя : ${name}</td>
            </tr>
            <tr class="profile-avatar">
                <td class="profile-avatar-text">Логин : ${login}</td>
            </tr >
            <tr class="profile-avatar">
                <td class="profile-avatar-text">Дата регистрации : ${dateReg}</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div align="center">
        <table>
            <tbody>
            <tr class="profile-avatar">
                <td><img src="resources/img/trackProfile.png" width="64" height="64"></td>
                <td class="profile-avatar-text" colspan="4">Треки принадлежащие ${name}</td>
            </tr>
            <tr class="profile-avatar">
                <td class="profile-avatar-text">Название</td>
                <td class="profile-avatar-text">Альбом</td>
                <td class="profile-avatar-text">Жанр</td>
                <td class="profile-avatar-text">BPM</td>
                <td class="profile-avatar-text">Длительность</td>
            </tr>
            <tr class="profile-avatar">
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            </tbody>
        </table>
        <div class="menu-button" onClick="location.href='${pageContext.request.contextPath}/manager.jsp'">
            <table>
                <tr>
                    <th>
                        <img src="resources/img/user.png" width="64" height="64">
                    </th>
                    <th> <p class="menu-button-text">Менеджер работы с аудиотекой</p></th>
                </tr>
            </table>
        </div>
    </div>
</body>
</html>
