<%@ page import="Beans.Recomendados" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Cancion> lista = (ArrayList<Cancion>) request.getAttribute("lista"); %>
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

            <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
                <div class="col-lg-6">
                    <h1 class='text-light'>Lista de Canciones </h1>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>CANCION</th>
                            <th>BANDA</th>
                            <th>  </th>
                        </tr>
                    </thead>

                    <tbody>
                        <% for (Cancion c: lista){ %>
                        <tr>
                            <td><%=c.getIdcancion()%></td>
                            <td><%=c.getNombreCancion()%></td>
                            <td><%=c.getBanda()%></td>
                            <td>
                                <button type="button" class="btn btn-danger btn-heart">
                                    <span class="heart"></span>
                                </button>
                            </td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>


            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script>
                $(document).ready(function() {
                    $(".btn-heart").click(function() {
                        $(this).toggleClass("btn-danger btn-success");
                    });
                });
            </script>

            <br>
            <br>
        </div>
        <jsp:include page="/static/scripts.jsp"/>

    </body>
</html>
