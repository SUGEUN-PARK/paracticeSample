<%--
  Created by IntelliJ IDEA.
  User: sugeunpark
  Date: 1/25/24
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="index.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="/resources/newForm.js"></script>
</head>
<body>
<!-- 상대경로 사용, [현재 URL이 속한 계층 경로 + /save] -->
<form action="http://localhost:8080/save.do" method="post">
    username: <input id="username" type="text" name="username" />
    age: <input id="age"  type="text" name="age" />
    <button type="submit">전송</button>

</form>
<button id="dbInsert">db저장</button>
<button id="autoWrite">자동완성</button>
</body>
</html>
