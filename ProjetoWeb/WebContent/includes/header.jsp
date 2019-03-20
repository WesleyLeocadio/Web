<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- start HEADER -->
	<div class="row header">
		<div class="content">
			<div class="header-logo">
				<h1>
					<span class="logo1">Faça</span> sua  
					<span class="logo2">Compra</span>
				</h1>
			</div>
			
			<div class="header-menu">
			<%  	String a= (String)session.getAttribute("user");%>
			
				<h2><%=a %></h2>
				
			</div>
		</div>
	 </div>
</body>
</html>