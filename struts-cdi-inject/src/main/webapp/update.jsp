<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 18/12/2021
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Hola Struts</title>
</head>
<body>
<div align="center">
    <h2>Formulario de Actualizacion</h2>

    <s:form action="actualizarAction">
        <s:hidden name="id" label="Id" value="%{obj.getId()}"/>
        <s:textfield name="nombre" label="Nombre" value="%{obj.getNombre()}"/>
        <s:textfield name="apellido" label="Apellido" value="%{obj.getApellido()}"/>
        <s:textfield name="direccion" label="Direccion" value="%{obj.getDireccion()}"/>
        <s:submit class="button-update" value="Actualizar" />
    </s:form>
</div>
<div align="center">
    <a href="listarAction">
        <button class="button-cancel">Regresar al Listado</button>
    </a>
</div>
</body>
</html>