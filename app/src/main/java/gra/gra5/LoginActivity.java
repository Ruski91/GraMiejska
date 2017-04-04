package gra.gra5;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    String show_Url = "http://192.168.8.104/select.php";

    String result = "";
    RequestQueue requestQueue;
    Boolean logowanie = false;
    CurrentUser cUser = new CurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button loginButton = (Button) findViewById(R.id.email_sign_in_button);
        Button rejestracja = (Button) findViewById(R.id.registration);
        final EditText emailEditText = (EditText) findViewById(R.id.email);
        final EditText hasloEditText = (EditText) findViewById(R.id.password);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        logowanie = false;
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                        show_Url, new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println(response.toString());
                        try {
                            JSONArray users = response.getJSONArray("users");
                            for (int i = 0; i < users.length(); i++) {
                                JSONObject user = users.getJSONObject(i);

                                String email = user.getString("email");
                                String haslo = user.getString("haslo");
                                String imie = user.getString("imie");
                                String nazwisko = user.getString("nazwisko");
                                String wiek = user.getString("wiek");
                                int punkty = user.getInt("punkty");
                                int nrZagadki = user.getInt("nrZagadki");
                                if(email.equals(emailEditText.getText().toString()) && haslo.equals(hasloEditText.getText().toString()))
                                {
                                    logowanie = true;
                                    CurrentUser.setCurrentUser(email,haslo,imie,nazwisko,wiek,nrZagadki,punkty);
                                    Intent inte = new Intent(LoginActivity.this, MainActivity.class);
                                    LoginActivity.this.startActivity(inte);
                                    if(logowanie)  Toast.makeText(getApplicationContext(), "Logowanie zakończone powodzeniem", Toast.LENGTH_LONG).show();
                                }


                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.append(error.getMessage());

                    }
                });
                requestQueue.add(jsonObjectRequest);

            }



        });


        rejestracja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inte1 = new Intent(LoginActivity.this, RejestracjaActivity.class);
                LoginActivity.this.startActivity(inte1);

            }
        });
    }

}