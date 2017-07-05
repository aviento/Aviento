package co.aviento.aviento;


/**
 * Created by parra on 06/06/2017.
 */
import java.util.Arrays;
public enum Ciudad
{
    CIUDAD(0,"** City **",0,0,0),
    BOGOTA(1,"Bogota",4.6482837,-74.2478962,9),
    VILLADELEYVA(2,"Villa de leyva",5.6364994,-73.5358133,14),
    SANGIL(3,"San Gil",6.5526427,-73.1536311,12),
    SUESCA(4, "Suesca",5.1039289,-73.8073867,14),
    RIONEGRO(5, "Rio negro",6.1448366,-75.3925951,13),
    CURITI(6,"Curiti",6.6045944,-73.0736183,14),
    PARAMO(7, "Paramo",6.4148207,-73.2322606,12),
    FLORIDABLANCA(8, "Floridablanca",7.0780151,-73.1163447,14),
    SANTAMARTA(9,"Santa Marta",11.2315232,-74.2174167,13),
    PALOMINO(10, "Palomino",11.2450075,-73.5601513,18),
    CARTAGENA(11, "Cartagena",10.400173,-75.5784663,12),
    SANANDRES(12, "San Andres",12.5404493,-81.7742951,12),
    PROVIDENCIA(13, "Providencia",13.3531747,-81.4077058,13),
    MEDELLLIN(14, "Medellin",6.2686594,-75.7364812,9),
    SANTAFEDEANTIOQUIA(15, "Santa fe de Antioquia",6.5385627,-76.0577071,11),
    GUATAPE(16, "Guatape",6.2317115,-75.1625134,16),
    RIOCLARO(17, "Rio Claro",5.5909378,-75.8716225,16),
    SALENTO(18, "Salento",4.637376,-75.5751544,16),
    MANIZALES(19, "Manizales",5.0686966,-75.5186628,13),
    VILLAVIEJA(20, "Villa vieja",3.2183569,-75.2219373,16),
    SANAGUSTIN(21, "San Agustin",1.8827021,-76.5979426,10),
    CALI(22, "Cali",3.3950543,-76.6657532,11),
    CALIMA(23, "Calima",3.9579922,-76.7760598,11),
    PAICOL(24,"Paicol",2.449478,-75.7772943,10);
    private int codigo;
    private String nombre;
    private  Double latitud, longitud;
    private  float zoom;
    Ciudad(int codigo, String nombre , double latitud, double longitud, float zoom)
    {
        this.codigo   = codigo;
        this.nombre   = nombre;
        this.latitud  = latitud;
        this.longitud = longitud;
        this.zoom     = zoom;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public static  String[] getNombres(){
        String[] resultado = new String[Ciudad.values().length];
        for (Ciudad tipo : Ciudad.values())
        {
            resultado[tipo.ordinal()] = tipo.nombre;
        }
        Arrays.sort(resultado);
        return resultado;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public float getZoom() {
        return zoom;
    }

    public void setZoom(float zoom) {
        this.zoom = zoom;
    }
}
