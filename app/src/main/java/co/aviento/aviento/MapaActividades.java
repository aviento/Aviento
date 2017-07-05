package co.aviento.aviento;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public abstract class MapaActividades extends AppCompatActivity implements OnMapReadyCallback, AdapterView.OnItemClickListener{
    private GoogleMap mMap;
    private static final int MY_PERMISSION_REQUEST_FINE_LOCATION = 101;
    private static final int MY_PERMISSION_REQUEST_COARSE_LOCATION = 102;
    private boolean permission_granted = false;
    protected int getLayoutId() {
        return R.layout.map;
    }
    public AdaptadorActividades adaptador;
    private String ciudades;
    private String actividades;
    private ListView listView;

    public void activarDesactivar(View button)
    {
        if (listView.getVisibility() == View.GONE)
        {
            animar(true);
            listView.setVisibility(View.VISIBLE);

        }
        else
        {
            listView.setVisibility(View.GONE);
        }
    }

    private void animar(boolean mostrar)
    {
        AnimationSet set = new AnimationSet(true);
        Animation animation = null;
        if (mostrar)
        {
            //desde la esquina inferior derecha a la superior izquierda
            animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        }
        //duración en milisegundos
        animation.setDuration(500);
        set.addAnimation(animation);
        LayoutAnimationController controller = new LayoutAnimationController(set, 0.25f);

        listView.setLayoutAnimation(controller);
        listView.startAnimation(animation);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this, VistaActividadPremium.class);
        i.putExtra("id", id);
        i.putExtra("tipo", 1);
        startActivity(i);

    }
    public String getCiudades() {
        return ciudades;
    }

    public String getActividades() {
        return actividades;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.buscar:
                Intent i = new Intent(this, Filtros.class);
                startActivityForResult(i, 1);
                return true;
            case R.id.mostrarfavoritos:
                Intent a = new Intent(this, ActividadesFavoritas.class);
                startActivity(a);
                return true;
            case R.id.mostrarTodos:
                Intent b = new Intent(this, ActividadesAgrupadas.class);
                startActivity(b);
                return true;
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            actividades = data.getStringExtra("actividad");
            ciudades = data.getStringExtra("ciudad");
            getMap().clear();
            startDemo();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        adaptador = new AdaptadorActividades(this);
        listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(adaptador);
        listView.setOnItemClickListener(this);
        setUpMap();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMap();
    }

    @Override
    public void onMapReady(GoogleMap map) {
        if (mMap != null) {
            return;
        }
        mMap = map;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},MY_PERMISSION_REQUEST_FINE_LOCATION);
            }
        }
        startDemo();
        mMap.setMyLocationEnabled(permission_granted);

    }

    private void setUpMap() {
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case MY_PERMISSION_REQUEST_FINE_LOCATION:
                if(grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {
                    //Permisos garantizados
                    permission_granted = true;
                }
                else
                {
                    permission_granted = false;
                    Toast.makeText(getApplicationContext(), "This app requires location permission granted" , Toast.LENGTH_SHORT).show();
                    //Permisos denegados
                }
                break;
            case MY_PERMISSION_REQUEST_COARSE_LOCATION:
                break;
        }
    }

    /**
     * Run the demo-specific code.
     */
    protected abstract void startDemo();

    protected GoogleMap getMap() {
        return mMap;
    }
}
