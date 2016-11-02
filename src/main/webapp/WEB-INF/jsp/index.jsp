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

<form action="/getValue" method="POST" ><br>
    Counter key: <input type="text" name="key"><br>
    Kvet: <input type="text" name="kvet"><br>

    <input type="submit" value="Get" >
</form>

<br/>

</body>
</html>


