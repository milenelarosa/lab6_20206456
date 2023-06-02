package Daos;

import Beans.listarRecomendados;

import java.sql.*;
import java.util.ArrayList;

public class listarRecomendadosDao {
    public ArrayList<listarRecomendados> listarCancionesRecomendadas(){

        ArrayList <listarRecomendados> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        String sql = "SELECT c.idcancion, c.nombre_cancion, c.banda FROM reproduccion r, cancion c\n" +
                "WHERE r.cancion_idcancion = c.idcancion\n" +
                "group by c.idcancion\n" +
                "having count(idcancion) >2 order by count(idcancion) desc;";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

        try (Connection connection = DriverManager.getConnection(url, "root", "123456");
             Statement smt = connection.createStatement();
             ResultSet resultSet = smt.executeQuery(sql)) {

            while(resultSet.next()){
                listarRecomendados listarRecomendados = new listarRecomendados();
                listarRecomendados.setIdcancion(resultSet.getInt(1));
                listarRecomendados.setNombre_cancion(resultSet.getString(2));
                listarRecomendados.setBanda(resultSet.getString(3));
                lista.add(listarRecomendados);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return lista;
    }
}
