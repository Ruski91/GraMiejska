package gra.gra5;

/**
 * Created by Chrystian on 2017-03-21.
 */
public  class CurrentLocation {
    public static Double longitude;
    public static Double latitude;

    public static void setCurrentLocation(Double _long, Double _latit)
    {
        longitude = _long;
        latitude = _latit;
    }
}
