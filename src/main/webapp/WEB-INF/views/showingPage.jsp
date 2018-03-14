<%--
  Created by IntelliJ IDEA.
  User: codingsquid
  Date: 2018. 3. 10.
  Time: PM 3:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #title {
            color: cadetblue;
        }
        #content {
            color: cornflowerblue;
        }
    </style>
</head>
<body>
    <h1 id="title">data insert test</h1>
    <table id="content" border="1">
        <tr>
            <th>이름</th>
            <th>나이</th>
            <th>학번</th>
        </tr>
        <tr>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.identifier_num}</td>
        </tr>



    </table>
</body>
</html>
