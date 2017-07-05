package co.aviento.aviento;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by parra on 07/05/2017.
 */

public class VistaActividadPremium extends AppCompatActivity
{
    private  int id, favo, count, idfavo;;
    private Actividad actividad;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Bundle extras = getIntent().getExtras();

        if( extras.getInt("tipo") == 1)
        {
            id = (int) extras.getLong("id");
            actividad = Actividades.elementoPremium(id);

        }
        else
        {
            id = extras.getInt("id");
            actividad = Actividades.elemento(id);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_actividad_premium);
        actualizarVistar();
    }
    private void actualizarVistar()
    {
        favo = 0;
        count = 0;
        for (Favorito favorito : MisFavoritos.vectorFavoritos)
        {
            if(favorito.getActividad()==actividad)
            {
                favo = 1;
                idfavo = count;
            }
            count ++;
        }
        String htmlText = "<html><body style='text-align:justify;text-size:8'> %s </body></Html>";
        TextView nombre =(TextView)findViewById(R.id.nombre);
        nombre.setText(actividad.getNombre());
        ImageView foto = (ImageView)findViewById(R.id.foto);
        foto.setImageResource(actividad.getFoto());
        TextView tipo = (TextView)findViewById(R.id.tipo);
        tipo.setText(actividad.getTipo().getTexto());
        TextView direccion = (TextView)findViewById(R.id.direccion);
        direccion.setText(actividad.getEmpresa().getDireccion());

        WebView descripcion = (WebView)findViewById(R.id.webview);
        descripcion.loadData(String.format(htmlText, actividad.getDescripcion()),"text/html; charset=utf-8", "utf-8");
        descripcion.setBackgroundColor(0x00FFFFFF);

        TextView nombreEmpresa = (TextView)findViewById(R.id.empresa);
        nombreEmpresa.setText(actividad.getEmpresa().getNombre());
        TextView ciudad = (TextView)findViewById(R.id.ciudad);
        ciudad.setText(actividad.getCiudad().getNombre());
        TextView valor = (TextView)findViewById(R.id.valor);
        valor.setText("$" + Integer.toString(actividad.getValor()));
        TextView telefono = (TextView)findViewById(R.id.telefono);
        telefono.setText(actividad.getEmpresa().getTelefono());

    }
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        //getMenuInflater().inflate(R.menu.menu_actividad1, menu);
        if(favo==1)
        {
            getMenuInflater().inflate(R.menu.menu_actividad1, menu);
        }
        else
        {
            getMenuInflater().inflate(R.menu.menu_actividad2, menu);

        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.favoritoac:
                if (item.getTitle().equals(getResources().getString(R.string.favoritoac)))
                {

                    MisFavoritos.borrar(idfavo);
                    item.setIcon(R.drawable.favorite);
                    item.setTitle(getResources().getString(R.string.favoritoin));
                }
                else
                {
                    MisFavoritos.anyade(new Favorito(1, actividad));
                    item.setIcon(R.drawable.favoritesel);
                    item.setTitle(getResources().getString(R.string.favoritoac));
                }
                return true;
            case R.id.favoritoin:
                if (item.getTitle().equals(getResources().getString(R.string.favoritoac)))
                {

                    MisFavoritos.borrar(idfavo);
                    item.setIcon(R.drawable.favorite);
                    item.setTitle(getResources().getString(R.string.favoritoin));
                }
                else
                {
                    MisFavoritos.anyade(new Favorito(1, actividad));
                    item.setIcon(R.drawable.favoritesel);
                    item.setTitle(getResources().getString(R.string.favoritoac));
                }
                return true;
        }
        return false;
    }
    public void llamar(View view)
    {
        Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + actividad.getEmpresa().getTelefono()));
        startActivity(i);
    }
    public void enviarCorreo(View view)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Reserve " + actividad.getNombre());
        intent.putExtra(Intent.EXTRA_TEXT,  "Please, I need to book the " +  actividad.getNombre());
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{actividad.getEmpresa().getCorreo()});
        startActivity(intent);
    }
}