package www.restaurantmenu.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private Button LogOutSession;
    private FirebaseAuth LogOutAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        LogOutAuth = FirebaseAuth.getInstance();
        LogOutSession = (Button) findViewById(R.id.Logout);

        LogOutSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogOutAuth.signOut();
                startActivity(new Intent(HomeActivity.this,AuthActivity.class));
                finish();
            }
        });

    }
}