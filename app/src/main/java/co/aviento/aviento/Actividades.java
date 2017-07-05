package co.aviento.aviento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parra on 24/04/2017.
 */

public class Actividades
{
    protected  static List<Actividad> vectorActividades = ejemploActividades();
    protected  static List<Actividad> actividadesPremium = actividadesPremium();
    public Actividades()
    {
        vectorActividades = ejemploActividades();
        actividadesPremium = actividadesPremium();
    }
    static  Actividad elemento(int id)
    {
        return vectorActividades.get(id);
    }
    static Actividad elementoPremium(int id)
    {
        return actividadesPremium.get(id);
    }
    static void anyade(Actividad actividad)
    {
        vectorActividades.add(actividad);
    }
    static List<Actividad> actividadesPremium()
    {
        ArrayList<Actividad> actividades = new ArrayList<Actividad>();
        for(Actividad actividad : vectorActividades)
        {
            if (actividad.getEmpresa().getPaquete() == 2)
            {
                actividades.add(actividad);
            }
        }
        return actividades;
    }
    static void borrar(int id)
    {
        vectorActividades.remove(id);
    }
    private static List<Actividad> ejemploActividades()
    {
        ArrayList<Actividad> actividades = new ArrayList<Actividad>();
        actividades.add(new Actividad("Parapente chicamocha", R.drawable.parapente_chicamocha, TipoActividad.PARAGLINDING, "\n" + "The chicamocha canyon is an excellent site for thermal flight, accompanied by the majesty of its landscape. It can be practiced by pilots of all levels \"it is advisable to have the advice of a pilot who knows the site\", because of its good thermal conditions it is easy to do top landing, but also we find three optional landings on the banks of the river chicamocha with a wide cone of approach.", Ciudad.SANGIL, Empresa.PARAPENTECHICAMOCHA, 180000, 5));
        actividades.add(new Actividad("Cueva de vaca", R.drawable.cueva_vaca, TipoActividad.CAVE, "\n" + "Cave of the cow, cataloged as one of the most beautiful caves of Santander located in Curití.", Ciudad.CURITI, Empresa.CACUVANAAVENTURA, 35000, 3));
        actividades.add(new Actividad("Parapente la Calera", R.drawable.parapenteando, TipoActividad.PARAGLINDING, " \n" + "La Calera, Cundinamarca, 20 min from the 85 with 7, which is the place of free flight closest to the city of Bogota. You can have the opportunity to appreciate the valley of sopo, San Rafael Reservoir, La Calera and much of the savanna of Bogota, in addition to the exuberate native vegetation and different types of birds and other animals.", Ciudad.BOGOTA, Empresa. PARAPENTEANDO, 170000, 4));
        actividades.add(new Actividad("Escalada en Suesca", R.drawable.escalada_suesca, TipoActividad. RAPPEL, " \n" + "Great opportunity to learn the basic techniques of this fascinating sport, an extreme activity with the best instructors and all the safety equipment to measure your adrenaline.",Ciudad.BOGOTA, Empresa. SUESCALADA, 160000, 5));
        actividades.add(new Actividad("Rafting Rio Negro", R.drawable.rio_negro_rafting, TipoActividad.RAFTING, " \n" + "Promoted as our main activity. Its practice is carried out in the Black River, one of the most elevated slopes of the department (Cundinamarca). This tributary passes through a beautiful primary forest, with the particularity of having rapids that ensure new experiences and total fun. The black river has a rating of (3) in the medium-low level and (4) in the medium-high level.",Ciudad.BOGOTA, Empresa.RIONEGRORAFTING, 40000, 5));
        actividades.add(new Actividad("Cuatrimotos", R.drawable.grados_territorio_aventura, TipoActividad.FOURWHEElERS, "\n" + "Adventure activities in the nature offering a better quality of life for people, in addition to an unforgettable experience with adrenaline and vertigo downloads .", Ciudad.VILLADELEYVA, Empresa.GRADOSTERRITORIOAVENTURA, 40000, 5));
        actividades.add(new Actividad("Bicycle guided tours", R.drawable.ciclotrip, TipoActividad.MOUNTAINBIKE, "Tour with an experienced guide Know our history and culture and enjoy an incredible adventure in the natural landscapes of our region We can customize the tour to meet your expectations All our guided tours start at our office located in Cra 9 # 14- 101- Ricaurte Park - Villa de Leyva, includes a mtb trek mountain bike, safety accessories, healthy snacks, plenty of water and technical assistance on the road.", Ciudad.VILLADELEYVA, Empresa.CICLOTRIPTOURSBICYCLERENTAL, 40000, 5));
        actividades.add(new Actividad("Rafting Rio Suarez", R.drawable.colombia_rafting, TipoActividad.RAFTING, "\n" + "The characteristics of these rapids and the volume of water makes this river one of the most exciting in Colombia to practice rafting and kayaking, with fast class IV + V, especially for people who love extreme sports.",Ciudad.SANGIL, Empresa.COLOMBIARAFTING, 40000, 5));
        actividades.add(new Actividad("Suarez canyon biking tour", R.drawable.bikejunkies, TipoActividad.MOUNTAINBIKE, " \n" + "This is a great mix of downhill adrenaline and cross country riding pumping legs. On our way we will enjoy rich Andean valleys, fertile lands of great natural beauty and a glimpse of the traditional Colombian lifestyle. Our emblematic mountain bike tour of 31 miles (55km) is always supported by a 4 × 4 vehicle ..",Ciudad.SANGIL, Empresa.COLOMBIANBIKEJUNKIES, 210000, 5));
        actividades.add(new Actividad("WINDSURF", R.drawable.caribbean, TipoActividad.KYLESURF, " \n" + "Our goal is to offer you the best service and satisfy your needs, for this we are open to study your case and be able to offer you the best alternative .", Ciudad.SANTAMARTA, Empresa.CARIBBEANSAILINGSCHOOL, 170000, 4));
        actividades.add(new Actividad("Cabalgata", R.drawable.junglejoeminca, TipoActividad.HORSERIDER, " \n" + "For the lost waterfall, and another couple of waterfalls less than 1.5 miles from the hotel, it is a popular day trip to the landscape and wildlife along the way that are worth the trip on your own. Popular swimming spot Pozo Azul is 45 minutes walk; Bird watching along the descent is especially good.", Ciudad.SANTAMARTA, Empresa.JUNGLEJOEMINCAADVENTURES, 20000, 5));
        actividades.add(new Actividad("Kayak", R.drawable.ecofiwiturismo, TipoActividad.KAYAK , " \n" + "Clear kayaks for clear seas, the difference is clear.", Ciudad.SANANDRES, Empresa.ECOFIWITURISMOECOLOGICO, 20000, 5));
        actividades.add(new Actividad("Buceo", R.drawable.sonnydive, TipoActividad.DIVING, "Diving with SONNY DIVE SHOP in the Providencia Sea provides the exciting experience of contemplating the vast and majestic marine life, adventures that make the Scuba Diving a sport that has more and more fans around the world. We can assure you that an immersion with us will give you an endless repertoire of stories to tell.", Ciudad.PROVIDENCIA, Empresa.SONNYDIVESHOP, 200000, 5));
        actividades.add(new Actividad("Fly Boad", R.drawable.flyboad, TipoActividad.FLYBOARD, "\n" + "It is a new sport that has revolutionized the world. It is a board that allows the elevation in the air thanks to two jets of water to propulsion generated by a good Jet Ski. The movement in the air is created from the inclination of the feet. Everyone between 11 and 60 years of age can practice Flyboard. Its handling is easy and intuitive. It is similar to learning to ride a bike or water ski since it only requires a little balance. In just 5 minutes, 95% of people who try flyboard are flying.", Ciudad.GUATAPE, Empresa.FLYBOAD, 90000, 5));
        actividades.add(new Actividad("Bungee Jumping", R.drawable.colombiabungeejumping, TipoActividad.BUNGEEJUMPING, "\n" + "The jump is made with a special elastic cord that allows first to fall accelerating, then dampen the fall and cause rebounds, experiencing intense emotions of freedom and flight. All equipment used is imported and its use is based on a maximum limit of jumps. Each jump is registered by our personnel, allowing in this way to ensure that the elastic cord acted under the norms of safety, requirements and international standards necessary for the practice of this sport.", Ciudad.SANGIL, Empresa.COLOMBIABUNGEEJUMPING, 70000, 5));
        actividades.add(new Actividad("Buceo taganga", R.drawable.oceanscuba, TipoActividad.DIVING, "Tayrona Park is located at the foot  these mountains on the Caribbean Sea, its location is privileged and unique, free of hurricanes and similar phenomena. Its proximity to the high mountains makes cold winds come down and move water from the surface, bringing clean water full of nutrients up to the surface. Life is very dense and colorful. It is rare to see large animals although barracudas, rays and turtles among others are seen quite often. Typically it is full of small and medium creatures of all description. Hard and soft corals and fish of all colors decorate this wonderful place.", Ciudad.SANTAMARTA, Empresa.OCEANOSCUBADIVECENTER, 190000, 5));
        actividades.add(new Actividad("Trekking en playa Juan de Dios", R.drawable.trekkingpacifico, TipoActividad.TREKKING, "The only beach with white sand in Uramba. Spend a day enjoying the beach, walking among the caves and discovering the jungle there is in this place.", Ciudad.CALI, Empresa.TRIPTRIP, 50000,5 ));
        actividades.add(new Actividad("Rafting rio paez", R.drawable.raftingriopaez, TipoActividad.RAFTING, "An adventure on the Paez River that makes experiencing a real experience full of adrenaline aboard a raft. Naventura offers the service to live another adventure with nature.", Ciudad.PAICOL, Empresa.NAVENTURA, 45000 , 3));
        actividades.add(new Actividad("Rio Claro Adventure Tour", R.drawable.rioclaro, TipoActividad.RAFTING, "his private nature reserve was founded in 1970 with the intention of protecting the tropical rainforests in the Rio Claro Canyon and promoting recreational activities in the area. The marble canyon and river provide the perfect backdrop for an adventurous day away from the hustle and bustle of Medellin. You will have the option of customizing your tour by choosing from various optional outdoor activities.", Ciudad.MEDELLLIN, Empresa.LANDVENTURETRAVEL,180000,5 ));
        return actividades;
    }
}
