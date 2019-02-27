<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Leilões SD</title>
  <link type="text/css" href="index.css" rel="stylesheet">
</head>
<body>
<jsp:include page="notifications.jsp"/>
  <c:if test="${session.loggedIn != true}">
    <c:redirect url="/index.jsp" />
  </c:if>

  <div align="center" 	style="height: 200px;
   width: 400px;
    position: fixed;
    top: 20%;
    left: 70%;
    margin-top: -50px;
    margin-left: -200px;"
    bgcolor="#E6E6FA">
    
   
     <p class="center">Estatísticas</p>
    <table border="3" cellpadding="10" cellspacing="10" class="searchLeilaoDetalhe" >
   
            <td>
              <table>
				 <input type="button" value="Número de Leilões dos Últimos 10 dias" onclick="window.location = 'imprimedezleiloes.jsp'" class="center" > <br>
					<br>
				 <input type="button" value="Top 10 Criadores" onclick="window.location = 'imprimetop10criadores.jsp'" class="center" > <br>
					<br>
					 <input type="button" value="Top 10 Winners" onclick="window.location = 'imprimetop10ganhos.jsp'" class="center" > <br>
					<br>
					
	  			</table>
			 </td>
	 </table>
	 <br>
	 <input type="button" value="Voltar ao menu" onclick="window.location='menuadmin.jsp'">
  </div>
</body>
</html>

    
    
    
    
    
    
    
    
    
    