<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<jsp:include page="notifications.jsp"/>
  <title>ERROR</title>
</head>
<body>
  <h1>There was an error</h1>
  <p><s:property value="exceptionStack" /></p>
</body>
</html>
