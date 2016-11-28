package devf.mx.facebookaccountkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.facebook.accountkit.ui.AccountKitActivity;
import com.facebook.accountkit.ui.AccountKitConfiguration;
import com.facebook.accountkit.ui.LoginType;

public class MainActivity extends AppCompatActivity {

    public static int APP_REQUEST_CODE_PHONE = 99;
    public static int APP_REQUEST_CODE_EMAIL = 98;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.loggin_phone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginPhone();
            }
        });

        findViewById(R.id.loggin_email).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginEmail();
            }
        });
    }

    private void onLoginEmail() {
        /**
         *Creamos el intent apuntando a la clase AccountKitActivity para que se encargue
         * de la verificación
         */
        final Intent intent = new Intent(MainActivity.this, AccountKitActivity.class);

        /**
         *Configuramos para indicarle que va a ser una verificación de tipo email y
         * un request code para identificar la respuesta de esta solicitud
         */
        AccountKitConfiguration.AccountKitConfigurationBuilder configurationBuilder =
                new AccountKitConfiguration.AccountKitConfigurationBuilder(
                        LoginType.EMAIL,
                        AccountKitActivity.ResponseType.CODE);

        //Solo le pasamos como parametro la configuración anterior
        intent.putExtra(
                AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION,
                configurationBuilder.build());

        //lanzamos la solicitud de verificación
        startActivityForResult(intent, APP_REQUEST_CODE_EMAIL);
    }

    public void onLoginPhone() {

        /**
         *Creamos el intent apuntando a la clase AccountKitActivity para que se encargue
         * de la verificación
         */
        final Intent intent = new Intent(MainActivity.this, AccountKitActivity.class);

        /**
         *Configuramos para indicarle que va a ser una verificación de tipo telefono y
         * un request code para identificar la respuesta de esta solicitud
         */
        AccountKitConfiguration.AccountKitConfigurationBuilder configurationBuilder =
                new AccountKitConfiguration.AccountKitConfigurationBuilder(
                        LoginType.PHONE,
                        AccountKitActivity.ResponseType.CODE);

        //Solo le pasamos como parametro la configuración anterior
        intent.putExtra(
                AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION,
                configurationBuilder.build());
        //lanzamos la solicitud de verificación
        startActivityForResult(intent, APP_REQUEST_CODE_PHONE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("myLog", "code: " + requestCode);
    }


}
