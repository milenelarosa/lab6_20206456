package Servlets;

import Daos.CancionDao;
import Daos.CancionDePlaylistDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CancionDePlaylistServlet",urlPatterns = "/listaCancionesPorPlaylist")
public class CancionDePlaylistServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        CancionDao cancionDao = new CancionDao();
        String plyId = request.getParameter("idPly");
        request.setAttribute("listaCancionPlaylist", cancionDao.listarCancionesPlaylist(plyId));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaCancionesPorPlaylist.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
