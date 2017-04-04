package gra.gra5;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RejestracjaActivity extends AppCompatActivity {

    EditText email,haslo,wiek,imie,nazwisko;
    Button insert,show;
    TextView result;
    RequestQueue requestQueue;
    String insertUrl = "http://192.168.8.102:8080/zapis.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejestracja);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        email = (EditText)findViewById(R.id.email);
        haslo = (EditText)findViewById(R.id.password);
        wiek = (EditText)findViewById(R.id.wiek);
        insert = (Button)findViewById(R.id.registration);
        imie = (EditText)findViewById(R.id.imie);
        nazwisko = (EditText)findViewById(R.id.nazwisko);
        requestQueue = Volley.newRequestQueue(getApplicationContext());


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        String odp = response;
                        Toast.makeText(getApplicationContext(), odp, Toast.LENGTH_LONG).show();
                        if (odp.equals("Rejestracja udana"))
                        {




                                Intent inte = new Intent(RejestracjaActivity.this, LoginActivity.class);
                                RejestracjaActivity.this.startActivity(inte);

                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> parameters = new HashMap<String, String>();
                        parameters.put("email",email.getText().toString());
                        parameters.put("haslo",haslo.getText().toString());
                        parameters.put("wiek",wiek.getText().toString());
                        parameters.put("imie",imie.getText().toString());
                        parameters.put("nazwisko",nazwisko.getText().toString());


                        return parameters;
                    }
                };
                requestQueue.add(request);


            }
        });


    }

}