<%@ page import="DTos.DtoEquipos" %><%--
  Created by IntelliJ IDEA.
  User: labtel
  Date: 20/11/2026
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ include file="../index.jsp" %>
<jsp:useBean id="sedes" scope="request"
             type="java.util.ArrayList<com.lab10>"/>
<h1>Tipos de ticket</h1>
<a href="<%=ctx%>/equipos?accion=nuevo">Nuevo equipo de red</a>
<table>
  <tr><th>Evento</th><th>Descripción</th><th>Fecha</th><th>Lugar</th>
    <th>Ticket</th><th>Precio</th><th>Disponible</th><th>Acción</th></tr>
  <% DtoEquipos[] equipos;
    for (DtoEquipos e : equipos) { %>
  <tr>
    <td><%=(e.getHostname())%></td><td><%=(e.getTipo())%></td>
    <td><%=e.getFechaAlta()%></td><td><%=(e.getSede())%></td>
    <td><%=(e.getEstado())%></td><td><%=e.getIpGestion()%></td>
    <td><form method="post" action="<%=ctx%>/tickets">
      <input type="hidden" name="accion" value="borrar">
      <input type="hidden" name="id" value="<%=e.getIdEquipo()%>">
      <button>Eliminar</button>
    </form></td>
  </tr>
  <% } %>
</table>
