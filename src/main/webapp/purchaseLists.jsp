<%--
  Created by IntelliJ IDEA.
  User: olymp
  Date: 25.11.2016
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 style="text-align: left;">Purchase list</h2>
<form method="post" name="addItem">Add purchase&nbsp;&nbsp;&nbsp; <input maxlength="50" name="addPurchase" size="25" type="text" />&nbsp;<input name="btAddItem" type="submit" value="Add" />&nbsp;</form>
<p>&nbsp;</p>
<table border="0" cellspacing="1" cellpadding="4" align="left">
    <tbody>
    <tr>
        <td>someItem</td>
        <td><a title="Remove" href="/list/default?rm=default.someItem">remove</a></td>
    </tr>
    <tr>
        <td>12</td>
        <td>22</td>
    </tr>
    </tbody>
</table>
</body>
</html>
