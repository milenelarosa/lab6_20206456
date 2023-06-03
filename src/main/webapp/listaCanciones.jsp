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
                                <form method="post" action="<%=request.getContextPath()%>/listaFavoritos?a=l">
                                    <input type="hidden" name="idCancion" id="idCancion" value="<%=c.getIdcancion()%>">
                                    <input type="hidden" name="nameCancion" name="nameCancion" value="<%=c.getNombreCancion()%>">
                                    <input type="hidden" name="idBanda" name="idBanda" value="<%=c.getBanda()%>">
                                    <button type="submit" class="btn btn-heart <%= lista.contains(c.getIdcancion()) ? "btn-success" : "btn-danger" %>">
                                        <svg role="img" height="16" width="16" aria-hidden="true" viewBox="0 0 16 16" data-encore-id="icon" class="Svg-sc-ytk21e-0 ldgdZj">
                                            <path d="M15.724 4.22A4.313 4.313 0 0 0 12.192.814a4.269 4.269 0 0 0-3.622 1.13.837.837 0 0 1-1.14 0 4.272 4.272 0 0 0-6.21 5.855l5.916 7.05a1.128 1.128 0 0 0 1.727 0l5.916-7.05a4.228 4.228 0 0 0 .945-3.577z"></path>
                                        </svg>
                                    </button>
                                </form>
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
