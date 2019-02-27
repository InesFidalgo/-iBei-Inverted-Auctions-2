<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bye Bye! </title>
</head>
<body>
<jsp:include page="notifications.jsp"/>
	<div align="center">
	<s:form action="logout" method="post" 
	
	style="height: 200px;
    width: 400px;
    position: fixed;
    top: 50%;
    left: 40%;
    margin-top: -100px;
    margin-left: -200px;">
		
		<table border="3" cellpadding="10" cellspacing="10" class="logout" >
            <td>
              <table>
              <p>Logout com Sucesso! Volte Sempre!<p>
              </table>   
        	
        </td>
        </table>
			<br>
		 	<input type="button" value="Voltar à pagina Inicial!" onclick="window.location='index.jsp'">
		</div>
		 
	</s:form>
	</div>
</body>
</html>