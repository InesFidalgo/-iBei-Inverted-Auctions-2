<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<jsp:include page="notifications.jsp"/>
	<div align="center" 	
	style="height: 200px;
   width: 400px;
    position: fixed;
    top: 40%;
    left: 70%;
    margin-top: -50px;
    margin-left: -200px;"
    bgcolor="#E6E6FA">
	
	<table border="3" cellpadding="10" cellspacing="10" class="leiloesDezDias" >
            <td>
              <table>
    			<c:out value="${leiloesDezDiasBean.comandoresposta}"  />
        </table>
          </td>
          </table>   
		
		<br>
		 <input type="button" value="Voltar ao menu" onclick="window.location='estatisticas.jsp'">
		</div>
	
</body>
</html>