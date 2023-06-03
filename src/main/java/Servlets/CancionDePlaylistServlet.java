package Servlets;

import Beans.Cancion;
import Daos.CancionDao;
import Daos.CancionDePlaylistDao;
import Daos.RecomendadosDao;

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
        RecomendadosDao recomendadosDao = new RecomendadosDao();

        String plyId = request.getParameter("idPly");
        request.setAttribute("listaCancionPlaylist", cancionDao.listarCancionesPlaylist(plyId));
        request.setAttribute("listaRecomendados", recomendadosDao.listarCancionesRecomendadas());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaCancionesPorPlaylist.jsp");
        requestDispatcher.forward(request,response);


        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");

        switch (action) {

            case "c":
                String id = request.getParameter("idCancion");
                request.getRequestDispatcher("listaCancionesPorPlaylist.jsp").forward(request, response);
                break;

            case "b":
                String idStr = request.getParameter("idCancion");
                int id1 = Integer.parseInt(idStr);
                cancionDao.obteneridCancion(id1);
                response.sendRedirect(request.getContextPath() + "/listaCancionesPorPlaylist");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("p") == null ? "crear" :
                request.getParameter("p");

        CancionDao cancionDao = new CancionDao();
        switch (action) {
            case "crear":
                Cancion cancion = parseCancion(request);
                cancionDao.crearCancion(cancion);

                response.sendRedirect(request.getContextPath() + "/listaCancionesPorPlaylist");
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
