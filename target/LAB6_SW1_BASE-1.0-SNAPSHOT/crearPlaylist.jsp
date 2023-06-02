<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <!--Colocar como value: nombre de la presente página -->
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Crear Playlist"/>
    </jsp:include>

    <body>
        <div class='container'>
            <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="biblioteca"/>
            </jsp:include>

            <div class="pb-5 pt-4 px-2 titlecolor">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-6">
                            <h1 class="text-light">Crea Tu Playlist</h1>
                        </div>
                    </div>
                </div>
            </div>
            <div class="pb-5 pt-4 px-3 titlecolor">
                <form method="POST" action="<%=request.getContextPath()%>/listaBiblioteca?a=l">
                    <div class="mb-3">
                        <label for="idPly"><h4 class="text-light">ID de la Playlist</h4></label>
                        <h6 class="text-danger">Se recomienda utilizar un ID que inicie con tres letras mayúsculas seguido de un número del 0 a 9.</h6>
                        <input type="text" class="form-control" name="idPly" id="idPly">
                    </div>
                    <div class="mb-3">
                        <label for="plyName"><h4 class="text-light">Nombre de la Playlist</h4></label>
                        <input type="text" class="form-control" name="plyName" id="plyName">
                    </div>
                    <br>

                    <button type="submit" class="btn btn-primary">Enviar</button>
                    <a class="btn btn-danger" href="<%=request.getContextPath()%>/listaBiblioteca?a=l">Cancelar</a>
                </form>
            </div>

        </div>
        <jsp:include page="/static/scripts.jsp"/>

    </body>
</html>
