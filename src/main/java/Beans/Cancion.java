package Beans;

public class Cancion {
    private int idcancion;
    private String nombreCancion;
    private String banda;
    private int idPlaylist;

    public int getIdcancion() {
        return idcancion;
    }

    public void setIdcancion(int idcancion) {
        this.idcancion = idcancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }
}
