/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package co.aviento.aviento;



import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import co.aviento.aviento.model.MyItem;


public class ActividadesAgrupadas extends MapaActividades implements ClusterManager.OnClusterClickListener<MyItem>, ClusterManager.OnClusterInfoWindowClickListener<MyItem>, ClusterManager.OnClusterItemClickListener<MyItem>, ClusterManager.OnClusterItemInfoWindowClickListener<MyItem>
{

    private ClusterManager<MyItem> mClusterManager;
    @Override
    protected void startDemo() {

        mClusterManager = new ClusterManager<MyItem>(this, getMap());
        if (getCiudades()== null || getCiudades().equals("** City **"))
        {
            getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(2.924068, -72.847520), 5));
        }
        else
        {
            for (Ciudad ciudad : Ciudad.values())
            {
                if (ciudad.getNombre().equals(getCiudades()))
                {
                    getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(ciudad.getLatitud(), ciudad.getLongitud()), ciudad.getZoom()));
                }
            }
        }

        getMap().setOnCameraIdleListener(mClusterManager);
        getMap().setOnInfoWindowClickListener(mClusterManager);
        mClusterManager.setOnClusterInfoWindowClickListener(this);
        mClusterManager.setOnClusterItemInfoWindowClickListener(this);
        mClusterManager.setRenderer(new ItemRenderer());
        readItems();
        mClusterManager.cluster();
    }

    @Override
    public boolean onClusterClick(Cluster<MyItem> cluster) {
        return false;
    }

    @Override
    public void onClusterInfoWindowClick(Cluster<MyItem> cluster) {
    }

    @Override
    public boolean onClusterItemClick(MyItem item) {
        return false;
    }

    @Override
    public void onClusterItemInfoWindowClick(MyItem item)
    {
        switch (item.getPaquete())
        {
            case 1:
                Intent i = new Intent(this, VistaActividad.class);
                i.putExtra("id", item.getId());
                startActivity(i);
                break;

            case 2:
                Intent p = new Intent(this, VistaActividadPremium.class);
                p.putExtra("id", item.getId());
                startActivity(p);
            break;
        }

    }

    private class ItemRenderer extends DefaultClusterRenderer<MyItem>
    {

        public ItemRenderer()
        {   super(getApplicationContext(), getMap(), mClusterManager);
        }
        @Override
        protected void onBeforeClusterItemRendered(MyItem item, MarkerOptions markerOptions) {

            BitmapDrawable iconDrawable = (BitmapDrawable) getResources()
                    .getDrawable(item.getImagen());

            Bitmap iGrande = iconDrawable.getBitmap();
            Bitmap icono   = Bitmap.createScaledBitmap(iGrande,iGrande.getWidth() /8, iGrande.getHeight() /8, false);
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icono));
        }
    }
    private void readItems()
    {

        int i = 0;
        for(Actividad actividad : Actividades.vectorActividades)
        {
            GeoPunto p = actividad.getEmpresa().getPosicion();
            if(p!= null && p.getLatitud() != 0)

                if (getActividades() == null  || actividad.getTipo().getTexto().equals(getActividades()) || getActividades().equals("** Activity **") )
                {
                    Log.d(getActividades(), actividad.getTipo().getTexto());
                    if (actividad.getEmpresa().getPaquete()== 1)
                    {
                        mClusterManager.addItem(new MyItem(i, p.getLatitud(),  p.getLongitud(), actividad.getNombre(), actividad.getEmpresa().getDireccion(),actividad.getEmpresa().getPaquete(),
                                actividad.getTipo().getRecurso()));
                    }
                    else
                    {
                        mClusterManager.addItem(new MyItem(i, p.getLatitud(),  p.getLongitud(), actividad.getNombre(), actividad.getEmpresa().getDireccion(),actividad.getEmpresa().getPaquete(),
                                actividad.getTipo().getRecursoPremium()));
                    }


                }
                i++;
            }
    }
}

