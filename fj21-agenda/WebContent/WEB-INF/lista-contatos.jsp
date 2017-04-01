<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:import url="cabecalho.jsp"></c:import>

	<table>
		<tr>
			<th></th>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Endereco</th>
			<th>Data de Nascimento</th>
		</tr>
		<c:forEach var="contato" items="${contatos}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff'}">
				<td>${id.count}</td>
				<td>${contato.nome }</td>
				<td><c:choose>
						<c:when test="${not empty contato.email }">
							<a href="mailto:${contato.email }">${contato.email }</a>
						</c:when>

						<c:otherwise>
							E-mail nao informado
						</c:otherwise>
					</c:choose></td>
				<td>${contato.endereco }</td>
				<td><fmt:formatDate value="${contato.dataNascimento.time }"
						pattern="dd/MM/yyy"></fmt:formatDate></td>
						
				<td>
					<a href="mvc?logica=RemoveContatoLogic&id=${contato.id }">Remover</a>
				</td>
			</tr>
		</c:forEach>
	</table>

	<c:import url="rodape.jsp"></c:import>
</body>
</html>