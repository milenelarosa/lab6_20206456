package Daos;

import Beans.Recomendados;

import java.sql.*;
import java.util.ArrayList;

public class RecomendadosDao {

    private static String user = "root";
    private static String pass = "123456";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
    public ArrayList<Recomendados> listarCancionesRecomendadas(){

        ArrayList <Recomendados> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        String sql = "SELECT c.idcancion, c.nombre_cancion, c.banda FROM reproduccion r, cancion c\n" +
                "WHERE r.cancion_idcancion = c.idcancion\n" +
                "group by c.idcancion\n" +
                "having count(idcancion) >2 order by count(idcancion) desc;";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement smt = connection.createStatement();
             ResultSet resultSet = smt.executeQuery(sql)) {

            while(resultSet.next()){
                Recomendados Recomendados = new Recomendados();
                Recomendados.setIdcancion(resultSet.getInt(1));
                Recomendados.setNombre_cancion(resultSet.getString(2));
                Recomendados.setBanda(resultSet.getString(3));
                lista.add(Recomendados);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return lista;
    }
}
