package co.aviento.aviento;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Filtros extends AppCompatActivity {
    private Spinner ciudad , actividad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_filtros);
        ciudad = (Spinner) findViewById(R.id.filtroCiudad);
        actividad = (Spinner) findViewById(R.id.filtroActividad);

        ciudad.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Ciudad.getNombres()));
        actividad.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, TipoActividad.getNombres()));
    }
    public void buscar(View view)
    {
        Intent BackIntent = new Intent();
        BackIntent.putExtra("ciudad", ciudad.getSelectedItem().toString());
        BackIntent.putExtra("actividad", actividad.getSelectedItem().toString());
        setResult(RESULT_OK, BackIntent);
        finish();
    }
}
