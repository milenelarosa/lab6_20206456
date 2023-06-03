package Daos;

import Beans.Playlist;
import Beans.Recomendados;

import java.sql.*;
import java.util.ArrayList;

public class PlaylistDao {

    private static String user = "root";
    private static String pass = "123456";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";


    public ArrayList<Playlist> listarPlaylist(){

        ArrayList <Playlist> listaPlaylist = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        String sql = "SELECT * FROM playlist;";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement smt = connection.createStatement();
             ResultSet resultSet = smt.executeQuery(sql)) {

            while(resultSet.next()){
                Playlist playlist = new Playlist();
                playlist.setIdplaylist(resultSet.getString(1));
                playlist.setNombrePlaylist(resultSet.getString(2));
                listaPlaylist.add(playlist);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return listaPlaylist;
    }

    public void crearPlaylist (Playlist playlist) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
        String sql = "INSERT INTO playlist (idplaylist, nombre_playlist) VALUES (?,?)";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, playlist.getIdplaylist());
            pstmt.setString(2, playlist.getNombrePlaylist());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void borrarPlaylist(String idPlaylist) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
        String sql = "DELETE FROM playlist WHERE idplaylist = ?";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, idPlaylist);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
