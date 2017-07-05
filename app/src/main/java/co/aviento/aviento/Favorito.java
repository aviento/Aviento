package co.aviento.aviento;

/**
 * Created by diego on 25/06/2017.
 */

public class Favorito {
    private  int favorito;
    private Actividad actividad;

    public Favorito(int favorito, Actividad actividad) {
        this.favorito = favorito;
        this.actividad = actividad;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

}