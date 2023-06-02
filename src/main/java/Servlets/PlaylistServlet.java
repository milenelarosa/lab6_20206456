package Servlets;

import Beans.Playlist;
import Daos.CancionDao;
import Daos.PlaylistDao;
import Daos.RecomendadosDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PlaylistServlet",urlPatterns = "/listaBiblioteca")
public class PlaylistServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PlaylistDao playlistDao = new PlaylistDao();

        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");

        switch (action) {
            case "l":
                request.setAttribute("listaPlaylist", playlistDao.listarPlaylist());
                request.getRequestDispatcher("listaPlaylist.jsp").forward(request, response);
                break;
            case "c":
                request.getRequestDispatcher("crearPlaylist.jsp").forward(request, response);
                break;

            case "b":
                String id2 = request.getParameter("idPly");
                playlistDao.borrarPlaylist(id2);
                response.sendRedirect(request.getContextPath() + "/listaBiblioteca?a=l");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("p") == null ? "crear" :
                request.getParameter("p");

        PlaylistDao playlistDao = new PlaylistDao();

        switch (action) {
            case "crear":
                Playlist playlist = parsePlaylist(request);
                playlistDao.crearPlaylist(playlist);

                response.sendRedirect(request.getContextPath() + "/listaBiblioteca?a=l");
                break;
        }

    }

    public Playlist parsePlaylist(HttpServletRequest request) {

        Playlist playlist = new Playlist();
        String playlistID = request.getParameter("idPly") != null ? request.getParameter("idPly") : "";
        String playlistName = request.getParameter("plyName");

        playlist.setIdplaylist(playlistID);
        playlist.setNombrePlaylist(playlistName);

        return playlist;
    }
}
