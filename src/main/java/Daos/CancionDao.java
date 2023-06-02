package Daos;

import Beans.Cancion;

import java.sql.*;
import java.util.ArrayList;

public class CancionDao {

    private static String user = "root";
    private static String pass = "123456";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

    public ArrayList<Cancion> listarCanciones(){

        ArrayList <Cancion> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        String sql = "SELECT * from cancion;";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement smt = connection.createStatement();
             ResultSet resultSet = smt.executeQuery(sql)) {

            while(resultSet.next()){
                Cancion Cancion = new Cancion();
                Cancion.setIdcancion(resultSet.getInt(1));
                Cancion.setNombreCancion(resultSet.getString(2));
                Cancion.setBanda(resultSet.getString(3));
                lista.add(Cancion);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return lista;
    }

    public ArrayList<Cancion> listarCancionePorBanda(String bandaId){

        ArrayList <Cancion> listaCancionesBanda = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql = "SELECT * from cancion WHERE banda = ?;";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

        try (Connection connection = DriverManager.getConnection(url, "root", "123456");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, bandaId);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while(rs.next()){
                    Cancion cancion = new Cancion();
                    cancion.setIdcancion(rs.getInt(1));
                    cancion.setNombreCancion(rs.getString(2));
                    cancion.setBanda(rs.getString(3));
                    listaCancionesBanda.add(cancion);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCancionesBanda;
    }

    public Cancion obteneridBanda(String bandaId) {
        Cancion cancion = null;
        try {
            String url = "jdbc:mysql://localhost:3306/hr";
            String sql = "SELECT * FROM cancion WHERE banda = ?";

            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(url, user, pass);
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setString(1, bandaId);

                try (ResultSet rs = preparedStatement.executeQuery()) {
                    if (rs.next()) {
                        cancion = new Cancion();
                        cancion.setIdcancion(rs.getInt(1));
                        cancion.setNombreCancion(rs.getString(2));
                        cancion.setBanda(rs.getString(3));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return cancion;
    }
}
