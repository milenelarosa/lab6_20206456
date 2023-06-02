<%@ page import="java.util.ArrayList" %>
<%@ page import="Beans.Playlist" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Playlist> listaPlaylist = (ArrayList<Playlist>) request.getAttribute("listaPlaylist"); %>
<html>
    <!--Colocar como value: nombre de la presente página -->
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Playlist"/>
    </jsp:include>
    <body>
        <div class='container'>
            <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="biblioteca"/>
            </jsp:include>

            <div class="pb-5 pt-4 px-3 titlecolor">
                <div class="container-fluid">
                    <h1 class='text-light'>Biblioteca </h1>
                    <br>
                    <br>
                    <div class="row">
                        <div class="col-lg-6">
                            <h2 class="text-light">Tus Playlists</h2>
                        </div>
                        <div class="col-lg-6 text-right">
                            <a class="btn btn-info" href="<%=request.getContextPath()%>/listaBiblioteca?a=c">Añadir Nueva Playlist</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre de la Playlist</th>
                            <th>  </th>
                            <th>  </th>
                        </tr>
                    </thead>

                    <tbody>
                        <% for (Playlist playlist: listaPlaylist){ %>
                        <tr>
                            <td><%=playlist.getIdplaylist()%></td>
                            <td><%=playlist.getNombrePlaylist()%></td>
                            <td><a href="<%=request.getContextPath()%>/listaCancionesPorPlaylist?&idPly=<%=playlist.getIdplaylist()%>" class="btn btn-outline-success"> Ir</a></td>
                            <td><a onclick="return confirm('¿Estas seguro de borrar :( ?')" class="btn btn-outline-secondary"
                                   href="<%=request.getContextPath()%>/listaBiblioteca?a=b&idPly=<%=playlist.getIdplaylist()%>">❌</a>
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
