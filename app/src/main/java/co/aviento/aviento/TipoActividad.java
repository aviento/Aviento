package co.aviento.aviento;

/**
 * Created by parra on 24/04/2017.
 */
import java.util.Arrays;
public enum TipoActividad
{
    ACTIVIDAD("** Activity **", 0, 0),
    BUNGEEJUMPING("Bungee jumping", R.drawable.bungee_jumping, R.drawable.bungee_jumping_premium),
    CANOPING("canoping", R.drawable.canoping, R.drawable.canoping_premium),
    CAVE("cave" , R.drawable.cave, R.drawable.cave_premium),
    CLIMBING("climbing", R.drawable.climbing, R.drawable.climbing_premium),
    DIVING("diving" , R.drawable.civing, R.drawable.civing_premium),
    FLYBOARD("Fly Board",R.drawable.flyboard, R.drawable.flyboard_premium),
    FOURWHEElERS("Four Wheelers", R.drawable.four_wheelers, R.drawable.four_wheelers_premium),
    HANGGLIDER("Hang glider", R.drawable.hang_glider, R.drawable.hang_glider_premium),
    HOTAITBALLONING("Hot Air Balloning", R.drawable.hot_air_ballooning, R.drawable.hot_air_ballooning_premium),
    HORSERIDER("Horse rider", R.drawable.horse_ride, R.drawable.horse_ride_premium),
    JETSKI("Jet Ski", R.drawable.jet_ski, R.drawable.jet_ski_premium),
    KAYAK("kayak", R.drawable.kayak, R.drawable.kayak_premium),
    KYLESURF("Kyle surf", R.drawable.kyle_surf, R.drawable.kyle_surf_premium),
    MOUNTAINBIKE("Mountain Bike",R.drawable.mountain_bike, R.drawable.mountain_bike_premium),
    PARAGLINDING("paragliding", R.drawable.paragliding, R.drawable.paragliding_premium),
    RAFTING("rafting", R.drawable.rafting, R.drawable.rafting_premium),
    RAPPEL("rappel", R.drawable.rappel, R.drawable.rafting_premium),
    SKYDIVING("Sky civing" , R.drawable.sky_diving, R.drawable.sky_diving_premium),
    TREKKING("trekking",R.drawable.trekking, R.drawable.trekking_premium);

    private final String texto;
    private final int recurso;
    private final int recursoPremium;
    TipoActividad(String texto, int recurso, int recursoPremium) {
        this.texto = texto;
        this.recurso = recurso;
        this.recursoPremium = recursoPremium;
    }

    public String getTexto() {
        return texto;
    }

    public int getRecurso() {
        return recurso;
    }
    public static  String[] getNombres(){
        String[] resultado = new String[TipoActividad.values().length];
        for (TipoActividad tipo : TipoActividad.values())
        {
            resultado[tipo.ordinal()] = tipo.texto;
        }
        Arrays.sort(resultado);
        return resultado;
    }

    public int getRecursoPremium() {
        return recursoPremium;
    }
}

