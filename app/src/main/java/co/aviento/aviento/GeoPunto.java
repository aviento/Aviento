package co.aviento.aviento;


/**
 * Created by parra on 23/04/2017.
 */

public class GeoPunto
{
    private  double latitud, longitud;
    public GeoPunto(double longitud , double latitud)
    {
        this.longitud = longitud;
        this.latitud  = latitud;
    }

    @Override
    public String toString() {
        return "GeoPunto{" +
                "latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }
    public  double distancia(GeoPunto punto)
        {
            final double RADIO_TIERRA = 6371000;
            double dlat = Math.toRadians(latitud- punto.latitud);
            double dlon = Math.toRadians(longitud - punto.longitud);
            double lat1 = Math.toRadians(punto.latitud);
            double lat2 = Math.toRadians(latitud);
            double a    = Math.sin(dlat/2)* Math.sin(dlat/2)+
                          Math.cos(dlon/2) * Math.cos(dlon/2)*
                          Math.cos(lat1) * Math.cos(lat2);
            double c  = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1- a));
            return  c * RADIO_TIERRA;
        }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
