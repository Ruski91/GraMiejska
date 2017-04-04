package gra.gra5;

import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.beyondar.android.fragment.BeyondarFragmentSupport;
import com.beyondar.android.plugin.radar.RadarView;
import com.beyondar.android.plugin.radar.RadarWorldPlugin;
import com.beyondar.android.view.OnClickBeyondarObjectListener;
import com.beyondar.android.world.BeyondarObject;
import com.beyondar.android.world.GeoObject;
import com.beyondar.android.world.World;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadToRiddle extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, OnClickBeyondarObjectListener, View.OnClickListener {
    protected GoogleApiClient mGoogleApiClient;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    protected Location mLocation;
    private RadarView radarView;
    private RadarWorldPlugin mRadarPlugin;
    private List<BeyondarObject> showViewOn;
    private BeyondarFragmentSupport mBeyondarFragment;
    protected Button mShowMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_to_riddle);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .addApi(AppIndex.API).build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.MAPS_RECEIVE) == PackageManager.PERMISSION_GRANTED) {
            mLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        //    Toast.makeText(LeadToRiddle.this, " Lat : " + mLocation.getLatitude() + " Long" + mLocation.getLongitude(), Toast.LENGTH_LONG).show();
            mBeyondarFragment = (BeyondarFragmentSupport) getSupportFragmentManager().findFragmentById(R.id.beyondarFragment);
            World world = new World(this);
            world.setGeoPosition(prepareForDevice(mLocation.getLatitude()), prepareForDevice(mLocation.getLongitude()));
            showViewOn = Collections.synchronizedList(new ArrayList<BeyondarObject>());
            GeoObject g1 = new GeoObject(1l);
            g1.setGeoPosition(CurrentRiddle.szerGeo, CurrentRiddle.dlugGeo);
            g1.setImageResource(R.drawable.zapyt);
            g1.setName("Zagadka");
            world.addBeyondarObject(g1);
            radarView = (RadarView) findViewById(R.id.radarView);
            mRadarPlugin = new RadarWorldPlugin(this);
            mRadarPlugin.setRadarView(radarView);
            mRadarPlugin.setMaxDistance(200);
            world.addPlugin(mRadarPlugin);
            mBeyondarFragment.setWorld(world);
            mBeyondarFragment.setOnClickBeyondarObjectListener(this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }
    protected double prepareForDevice(double location)
    {
        String pomocniczy = String.valueOf(location);
        pomocniczy += "0000000d";
        return Double.parseDouble(pomocniczy);
    }
    protected double prepareFromGoogleMaps(double location)
    {
        String pomocniczy = String.valueOf(location);
        pomocniczy += "00000000d";
        return Double.parseDouble(pomocniczy);
    }
    @Override
    public void onClickBeyondarObject(ArrayList<BeyondarObject> arrayList) {
        Location lok1  = new Location("");
        Location lok2 = new Location("");
        lok1.setLatitude(mLocation.getLatitude());
        lok1.setLongitude(mLocation.getLongitude());
        lok2.setLatitude(CurrentRiddle.szerGeo);
        lok2.setLongitude(CurrentRiddle.dlugGeo);
        Toast.makeText(LeadToRiddle.this, "Dystans do zagadki to "+lok1.distanceTo(lok2), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "LeadToRiddle Page", // TODO: Define a title for the content shown.
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
                "LeadToRiddle Page", // TODO: Define a title for the content shown.
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
