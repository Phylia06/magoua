package com.example.magoua;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Connexion extends AppCompatActivity {
    Button con,inscription, forgetPassword;
    protected EditText mail, password;
    protected String VerificationID;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    protected ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        progressDialog = new ProgressDialog(this);
        setContentView(R.layout.activity_connexion);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        con = findViewById(R.id.con);
        mail = findViewById(R.id.mail);
        password = findViewById(R.id.password);
        inscription = findViewById(R.id.inscription);
        forgetPassword = findViewById(R.id.forgetPassword);
        progressDialog = new ProgressDialog(this);


        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText resetMail = new EditText(v.getContext());
                AlertDialog.Builder passwordRsset = new AlertDialog.Builder(v.getContext());
                passwordRsset.setTitle("reinitialiser le mot de passe");
                passwordRsset.setMessage("entre votre address mail");
                passwordRsset.setView(resetMail);
            }
        });

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
performLogin();
            }
        });
        Intent iins = new Intent(this,Inscription.class);
        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(iins);
            }
        });
    }

    private void performLogin() {

        String mail = this.mail.getText().toString();
        String password1 = password.getText().toString();

        if (!mail.matches(emailPattern)) {
            this.mail.setError("entrer une address email convenable");
        } else if (password1.isEmpty() || password1.length() < 6) {
            this.password.setError("mot de passe incorect, merci de bien vouloir " +
                    "entrer un mot de passe conforme");
        } else {
            progressDialog.setMessage("merci de bien vouloir patienter  ...");
            progressDialog.setTitle("connexion");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
try {
    SharedPreferences preferences = getSharedPreferences("User", MODE_PRIVATE);
    String nomutilisateurconnecter = preferences.getString("nom", "");
    String phone = preferences.getString("phone", "");
    String password = preferences.getString("password", "");
    String maill = preferences.getString("mail", "");
    if (maill.equals(mail) && password.equals(password1)){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
        progressDialog.dismiss();
    }else{
        progressDialog.dismiss();
        Toast.makeText(Connexion.this, "Donnee incompatible ou inexistant", Toast.LENGTH_SHORT).show();
    }
}catch (NullPointerException e){
    progressDialog.dismiss();
    Toast.makeText(Connexion.this, "Donnee incompatible ou inexistant", Toast.LENGTH_SHORT).show();
}

        }

    }
}

