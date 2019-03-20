<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Produto</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<%@include file="includes/header.jsp"%>
<div class="interface">

		<div align="center">
			<h1>Cadastro</h1>
			<br>
			<form action="CadastrarProduto" method="GET">
			    NOME      <input type="text" name="nome"><br><br>
				DESCRIÇÃO <input type="text" name="descricao"><br><br>
				PRECO     <input type="text" name="preco" ><br>
				<input type="submit" value="CADASTRAR" >
			</form>

		</div>
	</div>

	<%@include file="includes/Footer.jsp"%>


</body>
</html>