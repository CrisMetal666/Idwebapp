<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
      <meta http-equiv="content-type" content="text/html; charset=UTF-8">
      <title>Home Page</title>
      
      <link href="<c:url value="/resources/css/test.css" />" rel="stylesheet">
  </head>
<body>
<div id="content">
<h1 class="title">Sistema de Gestión</h1>

<p>Hola ${nombre} este es el menu de la aplicación:</p>

<!-- para cerrar sesion debemos enviar un token -->
<form action="${pageContext.request.contextPath}/j_spring_security_logout" method="post" id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.headerName}" />
	<button type="submit">Cerrar sesión</button>
</form>


<h3>Módulo Ventas</h3></td>
<p><a href="${pageContext.request.contextPath}/ventas/gestion/clientes">Operación: gestionar clientes</a></p>
<p><a href="${pageContext.request.contextPath}/ventas/gestion/presupuestos">Operación: gestionar presupuestos</a></p>
<p><a href="${pageContext.request.contextPath}/ventas/gestion/facturas">Operación: gestionar facturas</a></p>

<h3>Módulo Compras</h3></td>
<p><a href="${pageContext.request.contextPath}/compras/gestion/proveedores">Operación: gestionar proveedores</a></p>
<p><a href="${pageContext.request.contextPath}/compras/gestion/compras">Operación: gestionar compras</a></p>
<p><a href="${pageContext.request.contextPath}/compras/autorizar">Operación: autorizar compras</a></p>


<h3>Módulo Nóminas</h3></td>
<p><a href="${pageContext.request.contextPath}/nominas/gestion/trabajadores">Operación: gestionar trabajadores</a></p>
<p><a href="${pageContext.request.contextPath}/nominas/gestion/nominas">Operación: gestionar nóminas</a></p>

</body>
</html>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
<script>
var app = angular.module('myApp', []);

app.controller('myCtrl', function($scope, $http) {

  	$scope.test = function() {

  		console.log(document.getElementById("_csrf").value);

  		var token = document.getElementById("_csrf").value;

  		$http({
  	  	  	method: 'POST',
  	  	  	url: 'http://localhost:8080/menu/testing',
  	  		headers: {
  	  			'X-CSRF-TOKEN': token
  	  	  	}
  	  	}).then(function(response) {
  	    	console.log(response);
  	  	});

  	  	
  	}
});
</script>

<div ng-app="myApp" ng-controller="myCtrl">
<input type="hidden" id="_csrf" value="${_csrf.token}" />
<button ng-click="test()">Click me</button>
</div>
