<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Game</title>
</head>
<body>
<form method="post" th:action="@{/game/count}">
    <input type="number"/>
    <input type="submit" value="Ok"/>
</form>
</body>
</html>