<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 12/03/2020
  Time: 8:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@page import="model.Contactdao"%>
<jsp:useBean id="u" class="model.Contact"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
    int i=Contactdao.save(u);
    if(i>0){
        response.sendRedirect("/CrudJsp_war_exploded/addcontact-success.jsp");
    }else{
        response.sendRedirect("/CrudJsp_war_exploded/addcontact-error.jsp");
    }
%>
</body>
</html>
