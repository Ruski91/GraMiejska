package gra.gra5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

import java.util.HashMap;
import java.util.Map;

public class AccountActivity extends AppCompatActivity {

    String updateUrl = "http://192.168.8.104/update.php";
    RequestQueue requestQueue;
    TextView nrZag;
    EditText answer;
    Riddle rid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Button checkAnswer = (Button) findViewById(R.id.checkAnswer);
        answer = (EditText) findViewById(R.id.editText);
        TextView name = (TextView) findViewById(R.id.nameText);
        name.setText(CurrentUser.imie);
        TextView vorname = (TextView) findViewById(R.id.vonNameText) ;
        vorname.setText(CurrentUser.nazwisko);
        TextView age= (TextView) findViewById(R.id.ageText) ;
        age.setText(CurrentUser.wiek);
        TextView nrZag = (TextView) findViewById(R.id.riddleNrText);
        nrZag.setText(String.valueOf(CurrentUser.nrZagadki));
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        checkAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer.getText().toString().equals(CurrentRiddle.odpowiedz)) {
                    StringRequest request = new StringRequest(Request.Method.POST, updateUrl, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            String odp = response;
                            Toast.makeText(getApplicationContext(), odp, Toast.LENGTH_LONG).show();
                            if (odp.equals("Rejestracja udana")) {


                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> parameters = new HashMap<String, String>();
                            int nrZag = CurrentUser.nrZagadki + 1;
                            parameters.put("email", CurrentUser.email);
                            parameters.put("nrZagadki", Integer.toString(nrZag));
                            return parameters;
                        }
                    };
                    requestQueue.add(request);
                }
                rid = new Riddle();
                rid.getCurrentRiddle(getApplicationContext());
//            if(!Integer.toString(CurrentUser.nrZagadki).equals(nrZag.getText().toString()))
//            {
//                nrZag.setText(CurrentUser.nrZagadki);
//            }
            }


        });

    }

}









