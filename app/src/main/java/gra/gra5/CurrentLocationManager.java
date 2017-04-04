package gra.gra5;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;

/**
 * Created by Chrystian on 2017-03-21.
 */
public class CurrentLocationManager {
    LocationManager lmanager;
    Context context;
    LocationListener locationListener;
    CurrentLocation myLocation;
    Double latitude;
    Double longitude;

    public CurrentLocationManager(Context _context, LocationManager _lManager) {
        this.context = _context;
        this.locationListener = new MyLocationListener();
        lmanager = _lManager;
        if (ActivityCompat.checkSelfPermission(_context, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            lmanager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, locationListener);
        }

    }

    
}
