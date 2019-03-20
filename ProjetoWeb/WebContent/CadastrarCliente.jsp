<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- start HEADER -->
	<div class="row header">
		<div class="content">
			<div class="header-logo">
				<h1>
					<span class="logo1">Faça</span> sua <span class="logo2">Compra</span>
				</h1>
			</div>

			<div class="header-menu"></div>
		</div>
	</div>
	<div class="interface">

		<div align="center">
			<h1>Cadastro</h1>
			<br>
			<form action="CadastrarCliente" method="GET">
				NOME <br> <input type="text" name="nome"><br>
				SENHA <br> <input type="password" name="senha"><br>
				EMAIL <br> <input type="text" name="email"><br>
				ADMINISTRADOR <input type="radio" name="usuario" value="ADMINISTRADOR">
				USUÁRIO<input type="radio" name="usuario" value="USUARIO"><br>
				<br><input type="submit" value="Enviar" name="enviar"><br>
			</form>

		</div>
	</div>

	<div class="row footer">
		<div class="content">
			<p>&copy; 2019 - ProjetoWeb</p>
		</div>
	</div>
</body>
</html>