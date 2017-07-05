package co.aviento.aviento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import android.content.SharedPreferences;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class Login extends AppCompatActivity {

    EditText etUsuario, etContra;
    Button btnIngresar;
    JSONArray ja;
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        etUsuario = (EditText)findViewById(R.id.etUsuario);
        etContra = (EditText)findViewById(R.id.etContra);
        btnIngresar = (Button)findViewById(R.id.btnIngresar);


        final SharedPreferences sharprefs = getSharedPreferences("Archivologin", context.MODE_PRIVATE);

        SharedPreferences sharpref = getPreferences(context.MODE_PRIVATE);
        String valor = sharpref.getString("login","Usuario no existe");
        if (valor.equals("Usuario no existe"))
        {


        }
        else{
            Intent intent = new Intent(this, ActividadesAgrupadas.class);
            startActivity(intent);
        }
        //Toast.makeText(getApplicationContext(), "Dato guardado : "+valor,Toast.LENGTH_LONG).show();

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ConsultaPass("http://avientoapp.000webhostapp.com/webservices/consultarusuario.php?user="+etUsuario.getText().toString());

            }
        });
    }
    public void registrar(View view)
    {
        //Toast.makeText(Login.this, "Registar", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Login.this, Registro.class);
        startActivity(intent);
    }
    private void ConsultaPass(String URL) {

        Log.i("url",""+URL);


        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest =  new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
                public void onResponse(String response) {

                try {
                    ja = new JSONArray(response);
                    String contra = ja.getString(0);
                    if(contra.equals(etContra.getText().toString())){

                        Toast.makeText(getApplicationContext(),getResources().getString(R.string.bienvenido),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, ActividadesAgrupadas.class);
                        startActivity(intent);
                        SharedPreferences sharpref = getPreferences(context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharpref.edit();
                        editor.putString("login", etUsuario.getText().toString());
                        editor.commit();


                    }else{
                        Toast.makeText(getApplicationContext(),getResources().getString(R.string.verifica_contraseña),Toast.LENGTH_SHORT).show();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();

                    Toast.makeText(getApplicationContext(),R.string.usuario_no_existe,Toast.LENGTH_LONG).show();
                }


            }
        }, new Response.ErrorListener() { //metodos del error
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.erro_conexion),Toast.LENGTH_LONG).show();
            }
        });

        queue.add(stringRequest);



    }
}
