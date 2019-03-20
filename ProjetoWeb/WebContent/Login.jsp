<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import = "DAO.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/login.css">

</head>
<body>


    <a class="links" id="paracadastro"></a>
    <a class="links" id="paralogin"></a>
     
    <div class="content">      
      <!--FORMULÁRIO DE LOGIN-->
      <div id="login">
      
 
      <!--FORMULÁRIO DE CADASTRO-->
      <div id="cadastro">
        <form method="post" action="Autenticador"> 
          <h1>Login</h1> 
          <p> 
            <label for="email">E-mail</label>
            <input  name="email" required="required" type="email" placeholder="contato@htmlecsspro.com"/> 
          </p>
           
          <p> 
            <label for="senha">Sua senha</label>
            <input id="senha" name="senha" required="required" type="password" placeholder="ex. 1234"/>
          </p>
           
          <p> 
            <input type="submit" value="ENTRAR"/> 
          </p>
           
          <p class="link">  
            Já tá cadastrado?
            <a href="CadastrarCliente.jsp"> Realizar Cadastro </a>
          </p>
        </form>
      </div>
    </div>
  </div>   
</body>
</html>