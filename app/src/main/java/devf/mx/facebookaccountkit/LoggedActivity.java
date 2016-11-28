package devf.mx.facebookaccountkit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.facebook.accountkit.Account;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitCallback;
import com.facebook.accountkit.AccountKitError;
import com.facebook.accountkit.PhoneNumber;

public class LoggedActivity extends AppCompatActivity {

    private static final String TAG = "LoggedActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);

        AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
            @Override
            public void onSuccess(final Account account) {
                // Get Account Kit ID
                String accountKitId = account.getId();

                // Get phone number
                PhoneNumber phoneNumber = account.getPhoneNumber();
                String phoneNumberString = phoneNumber.toString();

                // Get email
                String email = account.getEmail();

                Log.i(TAG, phoneNumberString);
                Log.i(TAG, email);
            }

            @Override
            public void onError(final AccountKitError error) {
                // Handle Error
                Log.e(TAG, error != null ? error.toString() : "error");
            }
        });
    }
}
