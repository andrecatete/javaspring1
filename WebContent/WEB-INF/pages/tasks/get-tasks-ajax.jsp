<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	< type="text/java" src="resources/js/jquery.js"></>
</head>
<body>
	< type="text/java">
		function finalizar(id) {
			$.post("finalizatask", {'id' : id}, function() {
				$("#task_"+id).html("Finalizada")
			});			
		}
	</>
<a href="novatask">Inserir nova task</a>
<br /><br />
<table border="1">
	<tr>
		<th>Id</th>
		<th>Descri��o</th>
		<th>Finalizada</th>
		<th>Data de finaliza��o</th>
		<th>A��o 1</th>
		<th>A��o 2</th>
	<tr/>
	<c:forEach items="${tasks}" var="task">
	<tr>
		<td>${task.id}</td>
		<td>${task.descricao}</td>
		<c:if test="${task.finalizada eq false}">
			<td id="task_${task.id}"><a href="#" onclick="finalizar(${task.id})">
			Finalizar</a></td>
		</c:if>
		<c:if test="${task.finalizada eq true}">
			<td>Finalizada</td>
		</c:if>
		<td>
		<fmt:formatDate value="${task.dataFinalizacao.time}" 
		pattern="dd/MM/yyyy"/>
		</td>
		<td><a href="excluitask?id=${task.id}">Excluir</a></td>
		<td><a href="buscartask?id=${task.id}">Editar</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>