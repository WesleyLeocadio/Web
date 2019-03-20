<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produtos</title>
</head>
<body>


	<div class="interface">
		<!-- and header-->
		<!-- start BEM VINDO -->
		<div class="row bem-vindo">
			<div class="content">
				<h1>Lista de Produtos</h1>
			</div>

		</div>


		<!-- and BEM VINDO-->
		<!-- start Artigos-->


		<table id="tabelaesp">
			<tr id="titulo">
				<th>Nome</th>
				<th>Descrição</th>
				<th>Preço</th>
				<th>Carrinho</th>
			</tr>
			<%@ page import="DAO.*"%>
			<%@ page import="java.util.List"%>
			    <%
				ProdutoDAO c = new ProdutoDAO();
				List<Produto> lista=c.buscarTodos(); 
				%>

			<%
				for(Produto u: lista){%>
				<tr>
				<th><%=u.getNome()%></th>
				<th><%=u.getDescricao() %></th>
				<th><%=u.getPreco()%></th>
				<th><a href="../CarrinhoServlet?id=<%=u.getId()%>&metodo=add">Adicionar</a></th></tr>
				<%} %>
		
		</table>
		<a href="receber-nome.jsp">Ver Carrinho</a>



	</div>

</body>
</html>