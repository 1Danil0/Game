<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Game</title>
</head>
<body>
<h3 th:text="${text}"></h3>

<form action="/create" method="post">
    Health <input type="number"/>
    <br>
    MinDamage <input type="number"/>
    <br>
    MaxDamage <input type="number"/>
    <br>
    Resistance <input type="number"/>
    <br>
    <input type="submit" value="Add">
</form>


</body>


</html>