<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 20/12/2021
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="./css/style.css" type="text/css">

<div class="center">
    <h1>
        CRUD de Clientes
    </h1>
</div>

<div class="center">
    <a href="register.jsp">
        <button class="button-register">Nuevo</button>
    </a>
</div>

<div class="center">
    <table class="tabla">
        <thead>
        <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Direccion</th>
            <th>Opciones</th>
        </tr>
        </thead>
        <s:iterator value="listado">
            <tr>
                <td><s:property value="id"/></td>
                <td><s:property value="nombre"/></td>
                <td><s:property value="apellido"/></td>
                <td><s:property value="direccion"/></td>
                <td>
                    <a href="buscarAction?id=<s:property value="id"/>">
                        <button class="button-update">Modificar</button>
                    </a>
                    <a href="eliminarAction?id=<s:property value="id"/>">
                        <button class="button-delete">Eliminar</button>
                    </a>
                </td>
            </tr>
        </s:iterator>
    </table>

</div>

