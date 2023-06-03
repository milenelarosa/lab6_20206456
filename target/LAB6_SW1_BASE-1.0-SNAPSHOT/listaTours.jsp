<%@ page import="Beans.Tour" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Tour> listaTours = (ArrayList<Tour>) request.getAttribute("listaTours"); %>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Tours"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="tours"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">
                <div class="col-lg-6">
                    <h1 class='text-light'>Lista de Tours</h1>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>ID</th>
                        <th>TOUR</th>
                        <th>BANDA</th>
                    </thead>
                    <%
                        for (Tour tour : listaTours) {
                    %>
                    <tr>
                        <td><%=tour.getIdTour()%>
                        </td>
                        <td><%=tour.getNombre_Tour()%>
                        </td>
                        <td><%=tour.getIdbanda()%>
                        </td>

                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>

        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
