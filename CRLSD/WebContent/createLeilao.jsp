<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Criar Leilao</title>
</head>
<body>
	<jsp:include page="notifications.jsp"/>
	<div align="center"> 	
	<s:form action="createLeilao" method="post" 	
	style="height: 200px;
   width: 400px;
    position: fixed;
   top: 25%;
    left: 70%;
    margin-top: -50px;
    margin-left: -200px;"
    bgcolor="#E6E6FA">
		<a>Titulo</a><s:textfield name="titulo" /><br>
		<a>Codigo</a><s:textfield name="codigo" /><br>
		<a>Detalhe</a><s:textfield name="detalhe" /><br>
		<a>Descricao</a><s:textfield name="descricao" /><br>
		<a>Dia</a><s:textfield name="dia" /><br>
		<a>Mes</a><s:textfield name="mes" /><br>
		<a>Ano</a><s:textfield name="ano" /><br>
		<a>Hora</a><s:textfield name="hora" /><br>
		<a>Minuto</a><s:textfield name="minuto" /><br>
		<a>Amount</a><s:textfield name="amount" /><br>
		
		<br>
		<s:submit href="/index"/><br>
		 <input type="button" value="Voltar ao menu" onclick="window.location='menu.jsp'">
	</s:form>
	
	</div>
</body>
</html>