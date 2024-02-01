<%@ page import="java.util.logging.Logger" %><%--
  Created by IntelliJ IDEA.
  User: sugeunpark
  Date: 1/5/24
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>--%>
<%@include file="index.jsp"%>
<html>
<head>
    
<%--    <script src="../js/jquery-3.7.1.min.js"></script>--%>
 <%--   <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous">
    </script>--%>
    <script src="/resources/example.js"></script>
    <%
        String data = (String)request.getAttribute("data");
        String ContextPath = (String)request.getAttribute("CONTEXT");

        Logger.getLogger("찍음 :" + data);
    %>




</head>
<body>
<input id="testInput"/>
<button id="testBt"></button>
<h3><%=data%></h3>
<h3><%=ContextPath%></h3>
<p>여기로 넘어오면 성공!</p>
</body>
</html>
