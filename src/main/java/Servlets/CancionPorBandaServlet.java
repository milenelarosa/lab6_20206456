package Servlets;

import Daos.CancionDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CancionPorBandaServlet",urlPatterns = "/listaCancionesPorBanda")
public class CancionPorBandaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        CancionDao cancionDao = new CancionDao();
        String bandaId = request.getParameter("idbanda");
        request.setAttribute("listaCancionBanda", cancionDao.listarCancionePorBanda(bandaId));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaCancionesPorBanda.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
