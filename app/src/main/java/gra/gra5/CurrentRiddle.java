package gra.gra5;

/**
 * Created by Chrystian on 2016-09-23.
 */
public class CurrentRiddle {
    public static int nrZagadki;
    public static String trescZagadki;
    public static String odpowiedz;
    public static double szerGeo;
    public static double dlugGeo;
    public static String dalsza;
    public static void setCurrentRiddle(int _nrZagadki, String _tresc, String _odp, double _szGeo, double _dlGeo, String _dalsza)
    {
        nrZagadki = _nrZagadki;
        trescZagadki = _tresc;
        odpowiedz = _odp;
        szerGeo = _szGeo;
        dlugGeo = _dlGeo;
        dalsza = _dalsza;
    }
}
