<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

</head>
<body>
<h1>Stromova aplikace</h1>

Stromy:
<table>
<tr><th>Nazev</th><th>Smazat</th></tr>
<c:forEach items="${stromy.keySet()}" var="nazev">
    <tr><td><c:out value="${nazev}"/></td><td><a href="/delete/${nazev}">smazat</a></td></tr>
</c:forEach>
</table>

<form action="/createStrom" method="POST" ><br>
    Nazev stromu: <input type="text" name="nazevStromu"><br>
    param1: <input type="text" name="param1"><br>
    param2: <input type="text" name="param2"><br>
    <input type="submit" value="Create">
</form>

<br/>

</body>
</html>


