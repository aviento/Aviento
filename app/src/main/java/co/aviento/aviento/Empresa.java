package co.aviento.aviento;


/**
 * Created by parra on 06/06/2017.
 */

public enum Empresa
{
    PARAPENTECHICAMOCHA("Parapente Chichamocha", "Cra 10 # 8- 38", "037-724-3839" , "www.parapentechicamocha.com" , "info@parapentechicamocha.com", 2, 6.552437, -73.130346),
    CACUVANAAVENTURA("Cacuvana Aventura", "Calle 8 # 11 - 80", "312393284" , "www.cacuvanaaventura.com" ,"", 1, 6.605674, -73.069903),
    PARAPENTEANDO ("Parapenteando", " Carrera 2 # 6-53, La Calera ","312565656", " http://yosoydelaire.wixsite.com/parapenteando/zonas ","" ,1, 4.7190824,-73.9698878),
    SUESCALADA ("Suescalada", " Calle 52A 18-92 | Local 6, Suesca ", "312565656" , " http://yosoydelaire.wixsite.com/parapenteando/zonas " ,"",1, 4.6408133,-74.0730067),
    RIONEGRORAFTING ("Rio Negro Rafting", " Rio Negro, Tobia", "313460709", "http://www.rionegrorafting.com/" ,"",1, 5.1224086,-74.4333803),
    GRADOSTERRITORIOAVENTURA ("90 grados territorio aventura", "Cra 9 # 10 - 63 | C.C. Casa Quinta Del Procer", "320844827", "", "",1,5.6320798,-73.5254552),
    CICLOTRIPTOURSBICYCLERENTAL ("Ciclotrip Tours & Bicycle Rental", " Cra 9 # 14-101- Parque Ricaurte ", "320844827"," http://www.ciclotrip.com/guidedtours" ,"",1, 5.6349235,-73.5236858),
    COLOMBIARAFTING ("Colombia Rafting Expediciones", " Carrera 10 N. 7-83", "32084482","http://www.colombiarafting.com/" ,"",1,  6.5522528,-73.1319084),
    CARIBBEANSAILINGSCHOOL ("Caribbean Sailing  School", " Via cienaga, km 14 Frente al hotel Irotama  ", "320547465" , "http://www.caribbean.com.co " ,"",1, 11.1492743,-74.2274747),
    JUNGLEJOEMINCAADVENTURES ("Jungle Joe Minca Adventures", " Minca", "317308527" , "www.junglejoeminca.com" ,"",1, 11.1428173,-74.1188656),
    ECOFIWITURISMOECOLOGICO ("Ecofiwi Turismo Ecologico", " San andres ", "317308533", "http://sanandresislas.es.tl/" ,"",2, 12.581718, -81.695378 ),
    SONNYDIVESHOP ("Sonny Dive Shop", " Minca", "317308527" , "www.sonnydiveshop.com/" ,"",1, 13.345832, -81.393332),
    FLYBOAD ("Flyboad", " guatape", "31479731" , "www.flyboardmedellin.com" ,"",1, 6.233183, -75.159037),
    COLOMBIABUNGEEJUMPING ("Colombia Bungee Jumping", " Km 2 vía San Gil | Charalá", "31479731" , "www.bungee.co" ,"info@colombiabungee.co",2, 6.534745, -73.125359),
    COLOMBIANBIKEJUNKIES ("Colombian Bike Junkies", " Calle 12 N 12-35", "320844827"," http://www.colombianbikejunkies.com/ " ,"",1,  6.5525179,-73.1368982),
    OCEANOSCUBADIVECENTER("Oceano Scuba Dive Center", " Carrera 2 No.17-46 | Esquina, Taganga", "57-5-4219004"," http://www.oceanoscuba.com.co" ,"",2,  11.2532525,-74.2137498),
    TRIPTRIP("Trip Trip" , "Cali 760001, Colombia", "57-3178953507", "www.triptrip.com", "", 1, 3.459263, -76.532757),
    NAVENTURA("Naventura", "Paicol 415001, Colombia", "57-3204632737", "www.naventura.co", "", 1, 2.4861464,-75.7282857),
    LANDVENTURETRAVEL("Landventure travel", "Medellín 050021" , "57-3217699555", "www.landventuretravel.co" , "landventuretravel@gmail.com", 1, 6.2145044,-75.5793837);
    private  String nombre;
    private  String direccion;
    private  String   telefono;
    private  String pagina;
    private  GeoPunto posicion;
    private  int paquete;
    private String correo;
    Empresa(String nombre, String direccion, String telefono, String pagina , String correo, int paquete, double latitud, double longitud)
    {
        posicion = new GeoPunto(longitud, latitud);
        this.nombre     = nombre;
        this.direccion  = direccion;
        this.telefono   = telefono;
        this.pagina     = pagina;
        this.paquete    = paquete;
        this.correo     = correo;
    }

    public int getPaquete() {
        return paquete;
    }

    public void setPaquete(int paquete) {
        this.paquete = paquete;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public GeoPunto getPosicion() {
        return posicion;
    }

    public void setPosicion(GeoPunto posicion) {
        this.posicion = posicion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
