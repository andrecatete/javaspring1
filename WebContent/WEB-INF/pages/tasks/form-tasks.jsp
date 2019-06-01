<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar task</title>
</head>
<body>
	<h2>Formulario de cadastro das <i>tasks</i></h2>
	<form action="cadastratask" method="post">
		<h3>Descrição</h3><br />
		<form:errors path="task.descricao" cssStyle="color:red" />
		<br />
		<br /><fmt:message key="teste.mensagem" />
		<br /><textarea name="descricao" rows="5" cols="100"></textarea>
		<input type="submit" value="Cadastrar">
	</form>
</body>
</html>