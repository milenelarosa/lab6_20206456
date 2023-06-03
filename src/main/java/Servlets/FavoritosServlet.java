package Servlets;

import Beans.Cancion;
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

@WebServlet(name = "FavoritosServlet",urlPatterns = "/listaFavoritos")
public class FavoritosServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CancionDao cancionDao = new CancionDao();
        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");

        switch (action) {
            case "l":
                request.setAttribute("listaFavorito", cancionDao.listarFavorito());
                request.getRequestDispatcher("listaFavoritos.jsp").forward(request, response);
                break;
            case "c":
                request.getRequestDispatcher("listaFavoritos.jsp").forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("p") == null ? "crear" :
                request.getParameter("p");

        CancionDao cancionDao = new CancionDao();

        switch (action) {
            case "crear":
                Cancion cancion = parseCancion(request);
                cancionDao.crearCancionenFavorito(cancion);

                response.sendRedirect(request.getContextPath() + "/listaFavoritos?a=l");
                break;
        }

    }

    public Cancion parseCancion(HttpServletRequest request) {

        Cancion cancion = new Cancion();
        String idCancionStr = request.getParameter("idCancion") != null ? request.getParameter("idCancion") : "";
        String nombreCancion = request.getParameter("nameCancion");
        String banda = request.getParameter("idBanda");

        try {
            int idCancion = Integer.parseInt(idCancionStr);
            cancion.setIdcancion(idCancion);
            cancion.setNombreCancion(nombreCancion);
            cancion.setBanda(banda);

            return cancion;

        } catch (NumberFormatException e) {

        }
        return cancion;
    }
}
