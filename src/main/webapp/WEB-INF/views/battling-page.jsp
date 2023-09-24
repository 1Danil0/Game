<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Game</title>
</head>
<body>

<h2>Your Details</h2>
<div th:if="${player.isAlive()} && ${monsters.size() != 0}">
    <table th:object="${player}">
        <tr>
            <th>Health</th>
            <th>MinDamage</th>
            <th>MaxDamage</th>
            <th>Resistance</th>
            <th>CountOfCuring</th>
            <th>To cure</th>
        </tr>
        <tr>
            <td> <p th:text="${player.getCurrentHealth()}"></p></td>
            <td> <p th:text="${player.getMinDamage()()}"></p></td>
            <td> <p th:text="${player.getMaxDamage()()}"></p></td>
            <td> <p th:text="${player.getResistance()}"></p></td>
            <td> <p th:text="${player.getCountOfCuring()()}"></p></td>
            <td>
                <form th:action="@{/game/cure}" method="post">
                    <input type="submit" value="Cure">
                </form>
            </td>
        </tr>
    </table>
    <h3>Monsters</h3>
    <table>
        <tr>
            <th>Health</th>
            <th>MinDamage</th>
            <th>MaxDamage</th>
            <th>Resistance</th>
            <th>To hit</th>
        </tr>
        <tr th:each="monster : ${monsters}">
            <td><p th:text="${monster.getCurrentHealth()()}"></p></td>
            <td><p th:text="${monster.getMinDamage()}"></p></td>
            <td><p th:text="${monster.getMaxDamage()()}"></p></td>
            <td><p th:text="${monster.getResistance()()}"></p></td>
            <td>
                <form th:action="@{/game/hit/id(id=${monsters.indexOf(monster)})}" method="post">
                    <input type="submit" value="Hit"/>
                </form>
            </td>
        </tr>
    </table>
</div>
<div th:if="${monsters.size() == 0}">
    <h3>You are winner</h3>
</div>
<div th:if="${!player.isAlive()}">
    <h3>Monsters won</h3>
</div>
</body>


</html>