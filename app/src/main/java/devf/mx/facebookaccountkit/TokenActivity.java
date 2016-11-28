package devf.mx.facebookaccountkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.accountkit.AccessToken;
import com.facebook.accountkit.AccountKit;

public class TokenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token);
        //Tenemos que verificar si tenemos un token de acceso del usuario valido
        AccessToken accessToken = AccountKit.getCurrentAccessToken();

        if (accessToken != null) {
            //Handle Returning User
            startActivity(new Intent(TokenActivity.this, MainActivity.class));
        } else {
            //Handle new or logged out user
        }
    }
}
