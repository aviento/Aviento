package co.aviento.aviento;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by parra on 07/06/2017.
 */

public class Mapa extends FragmentActivity implements OnMapReadyCallback , GoogleMap.OnInfoWindowClickListener
{
    private GoogleMap mapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mapa = googleMap;
        //mapa.setMyLocationEnabled(true);
        mapa.getUiSettings().setZoomControlsEnabled(true);
        mapa.getUiSettings().setCompassEnabled(true);
        if(Actividades.vectorActividades.size()>0)
        {
            GeoPunto p = Actividades.vectorActividades.get(0).getEmpresa().getPosicion();
            mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng(p.getLatitud(), p.getLongitud()),12));
        }
        for(Actividad actividad : Actividades.vectorActividades)
        {
            GeoPunto p = actividad.getEmpresa().getPosicion();
            if(p!= null && p.getLatitud() != 0)
            {
                BitmapDrawable iconDrawable = (BitmapDrawable) getResources()
                        .getDrawable(actividad.getTipo().getRecurso());

                Bitmap iGrande = iconDrawable.getBitmap();
                Bitmap icono   = Bitmap.createScaledBitmap(iGrande,iGrande.getWidth() /8, iGrande.getHeight() /8, false);
                mapa.addMarker(new MarkerOptions()
                .position(new LatLng(p.getLatitud(), p.getLongitud()))
                .title(actividad.getNombre()).snippet(actividad.getEmpresa().getDireccion())
                );
            }
        }

    }


    @Override
    public void onInfoWindowClick(Marker marker)
    {


    }
}
