<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 18/12/2021
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<link rel="stylesheet" href="./css/style.css" type="text/css">
<html>
<head>
    <title>Hola Struts</title>
</head>
<body>
<div align="center">
    <h2>Formulario de Registro</h2>
    <s:form action="crearAction">
        <s:textfield name="nombre" label="Nombre" />
        <s:textfield name="apellido" label="Apellido" />
        <s:textfield name="direccion" label="Direccion" />
        <s:submit class="button-register" value="Registrar" />
    </s:form>
</div>
<div class="center">
    <a href="listarAction">
        <button class="button-cancel">Cancelar</button>
    </a>
</div>
</body>
</html>