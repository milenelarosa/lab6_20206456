package Daos;

import Beans.Recomendados;
import Beans.Tour;

import java.sql.*;
import java.util.ArrayList;

public class TourDao {

    private static String user = "root";
    private static String pass = "123456";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";


    public ArrayList<Tour> listarTour(){

        ArrayList <Tour> listaTours = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        String sql = "SELECT * FROM tour r;";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement smt = connection.createStatement();
             ResultSet resultSet = smt.executeQuery(sql)) {

            while(resultSet.next()){
                Tour tour = new Tour();
                tour.setIdTour(resultSet.getInt(1));
                tour.setNombre_Tour(resultSet.getString(2));
                tour.setIdbanda(resultSet.getString(3));
                listaTours.add(tour);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return listaTours;
    }




}
