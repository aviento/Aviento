package co.aviento.aviento;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by parra on 29/05/2017.
 */

public class AdaptadorActividades extends BaseAdapter
{
    private LayoutInflater inflador;
    TextView nombre, direccion;
    ImageView foto;
    RatingBar valoracion;
    private List<Actividad> vectorLugares = Actividades.actividadesPremium();
    public AdaptadorActividades(Context contexto)
    {
        Log.d("Inicio","Inicio");
        inflador = (LayoutInflater)contexto
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View vistaReciclada, ViewGroup padre)
    {

        Actividad actividad = Actividades.elementoPremium(position);
        Log.d("Pocision","posición:" + position);
        if (vistaReciclada == null)
        {
            vistaReciclada = inflador.inflate(R.layout.elemento_lista, null);
        }
        nombre      = (TextView)vistaReciclada.findViewById(R.id.nombre);
        foto        = (ImageView)vistaReciclada.findViewById(R.id.foto);
        nombre.setText(actividad.getNombre());
        int id      = actividad.getTipo().getRecursoPremium();

        foto.setImageResource(id);
        foto.setScaleType(ImageView.ScaleType.FIT_END);
        return vistaReciclada;
    }

    @Override
    public int getCount() {
        return vectorLugares.size();
    }
    @Override
    public Object getItem(int position) {
        return Actividades.elementoPremium(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



}
