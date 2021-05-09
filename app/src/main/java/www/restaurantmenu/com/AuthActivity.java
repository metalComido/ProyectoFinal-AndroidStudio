package www.restaurantmenu.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class AuthActivity extends AppCompatActivity {

    private TextView EmailInput;
    private TextView passwordInput;
    private Button Login;

    private String email = "";
    private String password = "";

    private FirebaseAuth loginAut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        loginAut = FirebaseAuth.getInstance();

        EmailInput = (EditText) findViewById(R.id.editTextEmailAddress);
        passwordInput = (EditText) findViewById((R.id.editTextPassword));
        Login = (Button) findViewById(R.id.LoginButton);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = EmailInput.getText().toString();
                password = passwordInput.getText().toString();
                if (!email.isEmpty() && !password.isEmpty()) {
                    loginUser();
                } else {
                    Toast.makeText(AuthActivity.this, "Completa los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

        private void loginUser(){
            loginAut.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        startActivity(new Intent(AuthActivity.this,HomeActivity.class));
                    }
                    else {
                        Toast.makeText(AuthActivity.this,"No se realizo el inicio de sesion , compruebe los datos", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

    }
