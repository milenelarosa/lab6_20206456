<%@ page import="java.util.ArrayList" %>
<%@ page import="Beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Cancion> listaFavorito = (ArrayList<Cancion>) request.getAttribute("listaFavorito"); %>
<html>
    <!--Colocar como value: nombre de la presente página -->
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Favoritos"/>
    </jsp:include>
    <body>
        <div class='container'>
            <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="biblioteca"/>
            </jsp:include>

            <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">

                <div class="col-lg-6">
                    <h1 class='text-success'>
                        <br>Mis Canciones Favoritas </h1>
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
                        <% for (Cancion c: listaFavorito){ %>
                        <tr>
                            <td><%=c.getIdcancion()%></td>
                            <td><%=c.getNombreCancion()%></td>
                            <td><%=c.getBanda()%></td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>

            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script>
                $(document).ready(function() {
                    $(".btn-heart").click(function() {
                        $(this).toggleClass("btn-success btn-danger");
                    });
                });
            </script>
            <br>
        </div>
        <jsp:include page="/static/scripts.jsp"/>

    </body>
</html>
