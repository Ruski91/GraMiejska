package gra.gra5;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chrystian on 2016-09-23.
 */
public class CurrentUser {

    public static String email;
    public static String haslo;
    public static String imie;
    public static String nazwisko;
    public static String wiek;
    public static int nrZagadki;
    public static int punkty;

    public static void setCurrentUser(String _email, String _haslo, String _imie, String _nazwisko, String _wiek, int _nrZagadki, int _punkty) {
        email = _email;
        haslo = _haslo;
        imie = _imie;
        nazwisko = _nazwisko;
        wiek = _wiek;
        nrZagadki = _nrZagadki;
        punkty = _punkty;

    }
}


