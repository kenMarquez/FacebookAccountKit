package devf.mx.facebookaccountkit;

import android.app.Application;

import com.facebook.accountkit.AccountKit;

/**
 * Created by Ken on 27/11/16.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //Inicializamos el SDK de AccountKit de Facebook
        AccountKit.initialize(getApplicationContext());

    }


}
