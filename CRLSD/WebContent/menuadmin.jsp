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
    top: 0%;
    left: 70%;
    margin-top: -50px;
    margin-left: -200px;"
    bgcolor="#E6E6FA">
    
     <p class="center">Leilões SD</p>
    <table border="3" cellpadding="10" cellspacing="10" class="searchLeilaoDetalhe" >
            <td>
              <table>
               	 
				  <input type="button" value="Criar Leilao" onclick="window.location = 'createLeilao.jsp'" class="center" > <br>
				  <input type="button" value="Cancelar Leilao" onclick="window.location = 'cancelarLeilao.jsp'" class="center"> <br>
				  <input type="button" value="Utilizadores Online" onclick="window.location = 'online.jsp'" class="center"><br>
				  <input type="button" value="Procurar Leilao" onclick="window.location = 'imprimesearch.jsp'" class="center"><br>
				   <input type="button" value="Procurar Leilao Detalhe" onclick="window.location = 'imprimesearchdetalhe.jsp'" class="center"><br>
				    <input type="button" value="Procurar os Meus Leilões" onclick="window.location = 'imprimemyleiloes.jsp'" class="center">
		  		   <!--  <input type="button" value="Utilizadores Online" onclick="window.location = 'online.jsp'" class="center"><br>-->
		  		  <input type="button" value="Listar Versões Antigas de um Leilão" onclick="window.location = 'imprimelistarversoesantigas.jsp'" class="center"><br>
		  		  <input type="button" value="Listar as Minhas Licitações" onclick="window.location = 'imprimemylici.jsp'" class="center">
		  		  <br>
		  		   <input type="button" value="Mensagem Leilão" onclick="window.location = 'mensagemLeilao.jsp'" class="center">
		  		  <br>
		  		   <input type="button" value="Editar Leilão" onclick="window.location = 'editarLeilao.jsp'" class="center">
		  		  <br>
		  		  <input type="button" value="Licitar um Leilão" onclick="window.location = 'licitacoesLeilao.jsp'" class="center">
		  		  <br>
		  		    <input type="button" value="Ver a Minha Actividade Antiga" onclick="window.location = 'imprimeactividadeantiga.jsp'" class="center">
		  		  <br>
		  		  <input type="button" value="Associar ao Facebook" onclick="window.location = 'LoginFacebookAdmin.jsp'" class="center">
		  		
		  		 <br>
		  		 <br>
		  		 <p> Exclusivo Admin <p>
		  		 <input type="button" value="Banir um Utilizador" onclick="window.location = 'baniruser.jsp'" class="center"> <br>
		  		 <input type="button" value="Estatísticas" onclick="window.location = 'estatisticas.jsp'" class="center" > <br>
				 <br />
				   <j>Logout</j>
				  <s:form action="logout" method="POST">
				      <s:submit value="Logout" />
				  </s:form>
	  		</table>
			 </td>
	 </table>
  </div>
  

 
</body>
</html>
