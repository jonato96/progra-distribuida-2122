<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 18/12/2021
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div align="center">
  <h1>
    Bienvenido <s:property value="name" />, esta es una Aplicacion Struts
  </h1>
  <h2>
    El resultado de la suma es <s:property value="resultado"/>
  </h2>
</div>

<s:form action="readAction">

  <table>
    <thead>
    <tr style="background-color: #E0E0E1;">
      <th>Nombre</th>
      <th>Apellido</th>
      <th>Direccion</th>
    </tr>
    </thead>
    <s:iterator value="listado">
      <tr>
        <td><s:property value="nombre" /></td>
        <td><s:property value="apellido" /></td>
        <td><s:property value="direccion" /></td>
          <%--      <td>--%>
          <%--        <a href="updatedetails.action?submitType=updatedata&uemail=<s:property value="nombre"/>">--%>
          <%--          <button class="button-update">Update</button>--%>
          <%--        </a>--%>
          <%--        <a href="deleterecord.action?uemail=<s:property value="nombre"/>">--%>
          <%--          <button class="button-delete">Delete</button>--%>
          <%--        </a>--%>
          <%--      </td>--%>
      </tr>
    </s:iterator>
  </table>

</s:form>

