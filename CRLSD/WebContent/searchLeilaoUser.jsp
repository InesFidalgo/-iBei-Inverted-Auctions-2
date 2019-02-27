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
	<s:form action="searchLeilaoDetalhe" method="POST"  style="height: 200px;
   width: 400px;
    position: fixed;
    top: 20%;
    left: 70%;
    margin-top: -50px;
    margin-left: -200px;"
    bgcolor="#E6E6FA">
	
		   <c:forEach items="${searchLeilaoUserBean.auxa}" var="leilao" >
		 		<br>
               
               <tr>Id do Leilão: <input type="hidden" value="${leilao.id}" name="id"/> </tr>
		    	<li><c:out value="${leilao.id}"/></li>
		    	 <li><c:out value="${leilao.id['class']}"/></li>
		    	<s:submit value="Detalhes" class="btn btn-default"/>
		    	
			</c:forEach>
			
			
			
		
		 </s:form>
		
</body>
</html>