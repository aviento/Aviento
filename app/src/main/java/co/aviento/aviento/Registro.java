package co.aviento.aviento;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
public class Registro extends AppCompatActivity {

    Button btnconsultar, btnGuardar;
    EditText etId, etNombres, etTelefono,etPass;
    JSONArray ja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        btnGuardar = (Button)findViewById(R.id.btnGuardar);
        etId = (EditText)findViewById(R.id.etId);
        etNombres = (EditText)findViewById(R.id.etNombres);
        etPass     = (EditText)findViewById(R.id.etPass);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validarEmail(etId.getText().toString())){
                    etId.setError(getResources().getString(R.string.error_email));
                }
                else
                {
                    if (etNombres.getText().toString().isEmpty())
                    {
                        etNombres.setError(getResources().getString(R.string.error_nombre));
                    }

                    else if(etPass.getText().toString().isEmpty())
                    {
                        etPass.setError(getResources().getString(R.string.error_pass));
                    }
                    else
                    {
                        String nombres = etNombres.getText().toString().trim();
                        nombres = nombres.replaceAll(" ", "_");
                        registro("http://avientoapp.000webhostapp.com/webservices/registrar.php?username="+ nombres +"&email="+etId.getText().toString()+"&password="+etPass.getText().toString());
                    }

                }
            }
        });
    }
    private boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
    private void registro(String URL) {
        Log.i("url",""+URL);

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest =  new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.crear_usuario), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), Login.class );
                startActivity(intent);
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
