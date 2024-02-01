<%@ page language="java" contentType="text/html; charset=UTF-8" %><%@
        taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@
        taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %><%@
        taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%@
        taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--<c:set var="contextPath" value="${pageContext.request.contextPath}"/>--%>

<script>
    let contextPath = "${pageContext.request.contextPath}";
    $(function (){
        alert(contextPath);
    })

</script>