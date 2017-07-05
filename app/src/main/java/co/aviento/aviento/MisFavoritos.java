package co.aviento.aviento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diego on 25/06/2017.
 */

public class MisFavoritos {
    protected  static List<Favorito> vectorFavoritos = new ArrayList<Favorito>();

    public MisFavoritos()
    {

    }

    static Favorito elemento(int id)
    {
        return vectorFavoritos.get(id);
    }
    static void anyade(Favorito favoritos)
    {
        vectorFavoritos.add(favoritos);

    }

    static void borrar(int id)
    {
        vectorFavoritos.remove(id);
    }

}
