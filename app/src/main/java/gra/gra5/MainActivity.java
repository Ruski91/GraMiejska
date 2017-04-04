package gra.gra5;


        import android.content.Context;
        import android.content.Intent;
        import android.content.pm.ActivityInfo;
        import android.location.Location;
        import android.location.LocationManager;
        import android.net.Uri;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;

        import com.google.android.gms.appindexing.Action;
        import com.google.android.gms.appindexing.AppIndex;
        import com.google.android.gms.common.api.GoogleApiClient;
        import com.wikitude.architect.ArchitectView;
        import com.wikitude.architect.StartupConfiguration;

        import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Riddle> listaZagadek;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    Riddle  riddle  = new Riddle();
    LocationManager lManager ;
    CurrentLocationManager cLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Button buttonGra = (Button) findViewById(R.id.buttonGraj);
        Button buttonMap = (Button) findViewById(R.id.buttonMap);
        Button buttonLead = (Button) findViewById(R.id.buttonZagadka);
        Button buttonKonto = (Button) findViewById(R.id.buttonKonto);
        riddle.getCurrentRiddle(this);
        Toast.makeText(this, "Zagadka " +CurrentRiddle.nrZagadki, Toast.LENGTH_SHORT).show();
      //  lManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
       // cLocation = new CurrentLocationManager(this,lManager);
      //  Toast.makeText(MainActivity.this, CurrentLocation.longitude.toString(), Toast.LENGTH_SHORT).show();
        buttonKonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AccountActivity.class);
                startActivity(i);
            }
        });
        buttonLead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), LeadToRiddle.class);
                it.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(it);
            }
        });
        buttonGra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Graj = new Intent(MainActivity.this,
                        Gra.class);
                startActivity(Graj);
            }
        });
        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapa = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(mapa);
            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }

    @Override
    protected void onPause() {
        super.onPause();


    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://gra.gra5/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://gra.gra5/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}