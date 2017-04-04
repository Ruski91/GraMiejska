package gra.gra5;

import android.location.*;
import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.location.LocationListener;

/**
 * Created by Chrystian on 2017-03-21.
 */
public class MyLocationListener implements android.location.LocationListener {

    @Override
    public void onLocationChanged(Location location) {
        CurrentLocation.setCurrentLocation(location.getLongitude(), location.getLatitude());

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
