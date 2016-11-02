<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

</head>
<body>
<h1>Stromova aplikace</h1>

Stromy:
<table>
<thead>
<th><td>Nazev</td><td>Smazat</td></th>
</thead>
<tr><td></td><td></td></tr>
</table>

<form action="/getValue" method="POST" ><br>
    Counter key: <input type="text" name="key"><br>
    Kvet: <input type="text" name="kvet"><br>

    <input type="submit" value="Get" >
</form>

<br/>

</body>
</html>


