package Daos;

import Beans.Cancion;

import java.sql.*;
import java.util.ArrayList;

public class CancionDePlaylistDao {

    private static String user = "root";
    private static String pass = "123456";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

    public ArrayList<Cancion> listarCancionesPlaylist(String plyId){

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
}
