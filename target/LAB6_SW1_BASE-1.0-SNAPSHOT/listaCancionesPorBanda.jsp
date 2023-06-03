<%@ page import="java.util.ArrayList" %>
<%@ page import="Beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Cancion> listaCancionBanda = (ArrayList<Cancion>) request.getAttribute("listaCancionBanda"); %>
<html>
    <!--Colocar como value: nombre de la presente página -->
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Canciones"/>
    </jsp:include>
    <body>
        <div class='container'>
            <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="canciones"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-6">
                            <h1 class="text-light">Lista de Canciones Por Banda</h1>
                        </div>
                        <div class="col-lg-6 text-right">
                            <a class="btn btn-warning" href="<%=request.getContextPath()%>/listaCanciones">Mostrar todas las canciones</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>CANCION</th>
                            <th>BANDA</th>
                        </tr>
                    </thead>

                    <tbody>
                        <% for (Cancion b: listaCancionBanda){ %>
                        <tr>
                            <td><%=b.getIdcancion()%></td>
                            <td><%=b.getNombreCancion()%></td>
                            <td><%=b.getBanda()%></td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
            <br>
        </div>
        <jsp:include page="/static/scripts.jsp"/>

    </body>
</html>
