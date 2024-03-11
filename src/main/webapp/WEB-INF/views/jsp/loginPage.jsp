<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="/resources/login.js"></script>
    <script>
        $(function(){
            $("#btnLogin").click(function(){
                id=$("#id").val();
                var password=$("#password").val(); if(id == ""){
                    alert("아이디를 입력하세요");
                    $("#id").focus(); //입력포커스 이동

                    return; //함수 종료
                }
                if(password==""){
                    alert("비밀번호를 입력하세요");
                    $("#password").focus();
                    return;
                }
//폼 내부의 데이터를 전송할 주소
                document.form1.action= "http://localhost:8080/login_check.do";
                document.form1.submit(); //제출
            });
        });
    </script>
</head>

<body>

<h2>로그인</h2>
<form name="form1" method="post">
    <table border="1" width="400px">
        <tr>
            <td>아이디</td>
            <td><input id="id" name="id"></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" id="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="button" id="btnLogin">로그인 </button>
                <c:if test="${message == 'error'}">
                    <div style="color:red;"> 아이디 또는 비밀번호가 일치하지 않습니다.
                    </div>
                </c:if>
                <c:if test="${message == 'logout'}">
                    <div style="color:red;"> 로그아웃되었습니다.
                    </div>
                </c:if>
            </td>
        </tr>
    </table>
</form>
</body>
</html>