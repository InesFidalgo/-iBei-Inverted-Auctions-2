<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Leilões SD</title>
</head>
<body>

  <c:if test="${session.loggedIn == true}">
    <c:redirect url="menu.jsp" />
  </c:if>
   
  <div align="center" 	style="height: 200px;
    width: 400px;
    position: fixed;
    top: 50%;
    left: 50%;
    margin-top: -100px;
    margin-left: -200px;"
    bgcolor="#E6E6FA">
  <p>Insira a sua informação:</p>
  <s:form action="login" method="POST">
    Username: <s:textfield name="login"/>
    <br>
    Password: <s:password name="password"/>
    <br>
    <br>
    <s:submit value="Login" />
  </s:form>
  </div>
</body>
</html>
