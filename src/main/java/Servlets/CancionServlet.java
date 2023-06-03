package Servlets;

import Beans.Tour;
import Daos.CancionDao;
import Daos.RecomendadosDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CancionServlet",urlPatterns = "/listaCanciones")
public class CancionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        CancionDao cancionDao = new CancionDao();
        request.setAttribute("lista", cancionDao.listarCanciones());

        String bandaId = request.getParameter("idbanda");


        request.setAttribute("listaCancionBanda", cancionDao.listarCancionePorBanda(bandaId));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaCanciones.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
