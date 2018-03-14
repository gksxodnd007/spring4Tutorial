<%--
  Created by IntelliJ IDEA.
  User: codingsquid
  Date: 2018. 3. 4.
  Time: PM 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>${author}</h1>
    Hello World! Spring 4 By CodingSquid
    <form action="/addStudent" method="post">
        <input type="text" name="name" placeholder="name"/><br>
        <input type="text" name="age" placeholder="age"/><br>
        <input type="text" name="identifier_num" placeholder="identifier_num"/><br>
        <input type="submit" value="Complete" />
    </form>
</body>
</html>
