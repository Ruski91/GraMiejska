package gra.gra5;

import android.content.Context;
import android.os.AsyncTask;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chrystian on 2016-09-22.
 */
public class Riddle   {
    String showUrl = "http://192.168.8.104/selectAllRiddles.php";
    public int nrZagadki;
    public String trescZagadki;
    public String odpowiedz;
    public double szerGeo;
    public double dlugGeo;
    public String dalsza;
    String result = "";
    RequestQueue requestQueue;

    public  void getCurrentRiddle(final Context kontekst )
    {
        requestQueue = Volley.newRequestQueue(kontekst);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                showUrl, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response.toString());
                try {

                    JSONArray riddles = response.getJSONArray("riddles");
                    for (int i = 0; i < riddles.length(); i++) {
                        JSONObject riddle = riddles.getJSONObject(i);
                        Riddle ri = new Riddle();
                        ri.nrZagadki = riddle.getInt("numerZagadki");
                        ri.trescZagadki = riddle.getString("trescZagadki");
                        ri.odpowiedz = riddle.getString("odpowiedz");
                        ri.szerGeo =  riddle.getDouble("szerokoscGeo");
                        ri.dlugGeo = riddle.getDouble("dlugoscGeo");
                        ri.dalsza = riddle.getString("dalszaTresc");
                        if(ri.nrZagadki == CurrentUser.nrZagadki)
                        {
                            CurrentRiddle.setCurrentRiddle(ri.nrZagadki,ri.trescZagadki,ri.odpowiedz,ri.szerGeo,ri.dlugGeo,ri.dalsza);
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

}
