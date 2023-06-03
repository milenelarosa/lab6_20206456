<%@ page import="java.util.ArrayList" %>
<%@ page import="Beans.Cancion" %>
<%@ page import="Beans.Recomendados" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Cancion> listaCancionPlaylist = (ArrayList<Cancion>) request.getAttribute("listaCancionPlaylist"); %>
<% ArrayList<Recomendados> listaRecomendados = (ArrayList<Recomendados>) request.getAttribute("listaRecomendados"); %>

<html>
    <!--Colocar como value: nombre de la presente página -->
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Canciones"/>
    </jsp:include>
    <body>
        <div class='container'>
            <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="biblioteca"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-6">
                            <h1 class="text-light">Lista de Canciones Por Playlist</h1>
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
                        <% for (Cancion b: listaCancionPlaylist){ %>
                        <tr>
                            <td><%=b.getIdcancion()%></td>
                            <td><%=b.getNombreCancion()%></td>
                            <td><%=b.getBanda()%></td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
                <br>
                <br>
                <div class="container-fluid">
                    <h4 class="text-light">Recomendaciones </h4>
                    <h6 class='text-success'>Echa un vistazo a esta lista de recomendaciones y añade alguna de ellas a tu playlist </h6>
                    <br>

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
                                <% for (Recomendados lr: listaRecomendados){ %>
                                <tr>
                                    <td><%=lr.getIdcancion()%></td>
                                    <td><%=lr.getNombre_cancion()%></td>
                                    <td><%=lr.getBanda()%></td>

                                    <td>
                                        <form method="POST" action="<%=request.getContextPath()%>/listaCancionesPorPlaylist?a=c">
                                            <input type="hidden" name="idCancion" id="idCancion" value="<%=lr.getIdcancion()%>">
                                            <input type="hidden" name="nameCancion" name="nameCancion" value="<%=lr.getNombre_cancion()%>">
                                            <input type="hidden" name="idBanda" name="idBanda" value="<%=lr.getBanda()%>">
                                            <button type="submit" class="btn btn-red text-light">+</button>
                                        </form>
                                    </td>
                                </tr>
                                <% } %>
                            </tbody>
                        </table>
                        <br>
                    </div>
                </div>

            </div>
            <br>
        </div>
        <jsp:include page="/static/scripts.jsp"/>

    </body>
</html>
