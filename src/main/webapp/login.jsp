<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
  <head>
      <meta http-equiv="content-type" content="text/html; charset=UTF-8">
      <title>Iniciar Sesión</title>
  </head>
<body>
<div id="content">
<h1>Iniciar sesión</h1>

<form action="${pageContext.request.contextPath}/j_spring_security_check" method="post" role="form">
	<input type="text" name="usuario" placeholder="Usuario"></input></br>
	<input type="password" name="clave" placeholder="Clave"></input></br>
	<button type="submit" name="login-submit">Iniciar sesión</button></br>
	<p>${msm}</p>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>

</div>
</body>
</html>