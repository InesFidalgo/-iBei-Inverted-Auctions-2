<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Licitar Leil�o</title>
</head>
<body>
	<jsp:include page="notifications.jsp"/>
	<s:form action="licitacoes" method="post" 
	style="height: 200px;
   width: 400px;
    position: fixed;
    top: 40%;
    left: 70%;
    margin-top: -50px;
    margin-left: -200px;"
    bgcolor="#E6E6FA">
		
		<a>id do Leil�o:</a><s:textfield name="id"/><br>
		<a>Montante:</a><s:textfield name="montante"/><br>
			
		<s:submit href="/index"/><br>
		 <input type="button" value="Voltar ao menu" onclick="window.location='menu.jsp'">
	</s:form>
</body>
</html>