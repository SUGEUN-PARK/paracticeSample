<%--
  Created by IntelliJ IDEA.
  User: sugeunpark
  Date: 1/25/24
  Time: 5:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
    <c:forEach var="list" items="${list}">
        <tr> <td>${list.id}</td>
            <td>${list.name}</td>
            <td>${list.age}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>