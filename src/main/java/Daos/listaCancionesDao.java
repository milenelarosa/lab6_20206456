package Daos;

import Beans.listaCanciones;
import Beans.listarRecomendados;

import java.sql.*;
import java.util.ArrayList;

public class listaCancionesDao {
    public ArrayList<listaCanciones> listarCanciones(){

        ArrayList <listaCanciones> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        String sql = "SELECT idcancion, nombre_cancion, banda from cancion;";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

        try (Connection connection = DriverManager.getConnection(url, "root", "123456");
             Statement smt = connection.createStatement();
             ResultSet resultSet = smt.executeQuery(sql)) {

            while(resultSet.next()){
                listaCanciones listaCanciones = new listaCanciones();
                listaCanciones.setIdcancion(resultSet.getInt(1));
                listaCanciones.setNombreCancion(resultSet.getString(2));
                listaCanciones.setBanda(resultSet.getString(3));
                lista.add(listaCanciones);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return lista;
    }

    public ArrayList<listaCanciones> listarCancionesPorBanda(){

        ArrayList <listaCanciones> listaCancionBanda = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        String sql = "SELECT c.idcancion, c.nombre_cancion, c.banda from cancion c, banda b\n" +
                "WHERE c.banda = b.idbanda and c.banda = 'FOB'\n" +
                "order by idcancion;";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

        try (Connection connection = DriverManager.getConnection(url, "root", "123456");
             Statement smt = connection.createStatement();
             ResultSet resultSet = smt.executeQuery(sql)) {

            while(resultSet.next()){
                listaCanciones listaCanciones = new listaCanciones();
                listaCanciones.setIdcancion(resultSet.getInt(1));
                listaCanciones.setNombreCancion(resultSet.getString(2));
                listaCanciones.setBanda(resultSet.getString(3));
                lista.add(listaCanciones);
            }


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return lista;
    }
}
