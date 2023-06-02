<%@ page import="Beans.listarRecomendados" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<listarRecomendados> lista = (ArrayList<listarRecomendados>) request.getAttribute("lista"); %>
<html>
    <!--Colocar como value: nombre de la presente página -->
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Bienvenido"/>
    </jsp:include>
    <body>
        <div class='container'>
            <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value=""/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
                <div class="col-lg-6">
                    <h1 class='text-light'>Lista de Canciones Recomendadas: </h1>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>CANCION</th>
                            <th>BANDA</th>
                            <th>Ver</th>
                        </tr>
                    </thead>

                    <tbody>
                        <% for (listarRecomendados lr: lista){ %>
                        <tr>
                            <td><%=lr.getIdcancion()%></td>
                            <td><%=lr.getNombre_cancion()%></td>
                            <td><%=lr.getBanda()%></td>
                            <td>
                                <a href="<%=request.getContextPath()%>/listaRecomendados" class="btn btn-success"> Mas de la banda</a>
                            </td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
