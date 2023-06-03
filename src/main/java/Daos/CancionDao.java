package Daos;

import Beans.Cancion;
import Beans.Playlist;

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

        try (Connection connection = DriverManager.getConnection(url, user, pass);
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

    public Cancion obteneridCancion(int idCancion) {
        Cancion cancion = null;
        try {
            String url = "jdbc:mysql://localhost:3306/hr";
            String sql = "SELECT * FROM cancion WHERE idcancion = ?";

            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(url, user, pass);
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setInt(1, idCancion);

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

    public ArrayList<Cancion> listarCancionesPlaylist(String plyId){

        ArrayList <Cancion> listaCancionPlaylist = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql = "SELECT c.idcancion, c.nombre_cancion, c.banda\n" +
                "FROM cancion c, playlist p WHERE c.playlist_idplaylist = p.idplaylist AND p.idplaylist = ?;";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, plyId);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while(rs.next()){
                    Cancion cancion = new Cancion();
                    cancion.setIdcancion(rs.getInt(1));
                    cancion.setNombreCancion(rs.getString(2));
                    cancion.setBanda(rs.getString(3));
                    listaCancionPlaylist.add(cancion);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCancionPlaylist;
    }


    public void crearCancion (Cancion cancion) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO cancion (idcancion, nombre_cancion, banda) VALUES (?,?,?)";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, cancion.getIdcancion());
            pstmt.setString(2, cancion.getNombreCancion());
            pstmt.setString(3, cancion.getBanda());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Cancion> listarCancionesRecienAgregadas(String plyId){

        ArrayList <Cancion> listaCancionPlaylist = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql = "SELECT c.idcancion, c.nombre_cancion, c.banda\n" +
                "FROM cancion c, playlist p WHERE c.playlist_idplaylist = p.idplaylist AND p.idplaylist = ?;";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, plyId);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while(rs.next()){
                    Cancion cancion = new Cancion();
                    cancion.setIdcancion(rs.getInt(1));
                    cancion.setNombreCancion(rs.getString(2));
                    cancion.setBanda(rs.getString(3));
                    listaCancionPlaylist.add(cancion);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCancionPlaylist;
    }


    public void crearCancionenFavorito (Cancion cancion) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO favorito (idcancion, nombre_cancion, banda) VALUES (?,?,?)";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, cancion.getIdcancion());
            pstmt.setString(2, cancion.getNombreCancion());
            pstmt.setString(3, cancion.getBanda());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList<Cancion> listarFavorito(){

        ArrayList <Cancion> listaFavorito = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        String sql = "SELECT * from favorito;";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement smt = connection.createStatement();
             ResultSet resultSet = smt.executeQuery(sql)) {

            while(resultSet.next()){
                Cancion Cancion = new Cancion();
                Cancion.setIdcancion(resultSet.getInt(1));
                Cancion.setNombreCancion(resultSet.getString(2));
                Cancion.setBanda(resultSet.getString(3));
                listaFavorito.add(Cancion);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return listaFavorito;
    }

}
