package Servlets;

import Beans.Tour;
import Daos.RecomendadosDao;
import Daos.TourDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TourServlet",urlPatterns = {"/listaTours"})
public class TourServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        TourDao tourDao = new TourDao();
        request.setAttribute("listaTours", tourDao.listarTour());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaTours.jsp");
        requestDispatcher.forward(request,response);

    }
}
