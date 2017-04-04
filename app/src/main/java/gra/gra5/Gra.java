package gra.gra5;


import android.location.Location;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.wikitude.architect.ArchitectView;
import com.wikitude.architect.StartupConfiguration;

public class Gra extends AppCompatActivity {


    private ArchitectView architectView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_gra);
        this.architectView = (ArchitectView)this.findViewById( R.id.architectView );
        final StartupConfiguration config = new StartupConfiguration("Ao7EN9j6roTVP0C+LpgThxBpMfwjMnzs5Dt1eADIL+eentbEO/PouxK/DYtX9WuJnGLHD1vPGj3Lp5ZH/cSutCKsRTLHGUEcvLDFz4LpvsOumJfKcYt1EYYhBGAPaFRkiIOpMk60GcsrraLpgwXv6tYvdQRoifBEZK1Z6xA1QM9TYWx0ZWRfXwUH1LJ+HjlDurYbCF8H9M3uitsvodUCa1LIFghSh8b85B1RfKKRdfTQmZFP5olQZ7GxRwdHCAB2znWaGw1WuCxi3TCq1gQIaHDMHvqqaXTICQ8q8FWbiknXOEVnshCXYYl4oUE5gcsfF1xxkXdTJIbfsm9lioEgxc0P2t3xCmzdAlG6HhrcJRRe9kn0E1pj4CX7FO8VcKQnwKtm48kdxmcz1vsgbWBRPCk6KN7B3PEmRWkCzqDIy38aQT157uSN5sMPyDIQPcWCfxcGuBwqA1DO3FIj0hUQJBI7pAYS6efgjN3mM+fUDvheTKtnKyg1c5wLcsolWj3BJJV/MMT6FeBz6FKMh6TzUoDm4N/O+Yq5WqpCpAtM4c5No6kdzbMrhJeGHZQRMkkoe7t6JN1qu8t7faXWhzcJ9MbUS0JxQAKYS2+p75WrQmWvuMb9ltIcZKOruAxO3DT5cAJNTsIe2vZ/b46F/Wdnfgc3vHfmx6WRPio8fXCxN5E=");
        this.architectView.onCreate(config);



    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        architectView.onPostCreate();
        try {


            this.architectView.load( "file:///android_asset/demo/index.html" );

        }
        catch (Exception e){
        }


    }

    @Override
    protected void onResume(){
        super.onResume();

        this.architectView.onResume();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        this.architectView.onDestroy();
    }

    @Override
    protected void onPause(){
        super.onPause();

        this.architectView.onPause();
    }
}