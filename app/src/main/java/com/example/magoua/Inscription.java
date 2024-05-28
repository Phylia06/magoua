package com.example.magoua;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.magoua.modele.ImagePublicationAdapter;

import java.util.ArrayList;
import java.util.List;

public class Inscription extends AppCompatActivity {
    private EditText nom, phone, mail, mot_de_passe1, mot_de_passe2;
    private Button verification;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    protected ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inscription);
        progressDialog = new ProgressDialog(this);
        nom = findViewById(R.id.nom);
        phone = findViewById(R.id.phone);
        mail = findViewById(R.id.mail);
        mot_de_passe1 = findViewById(R.id.password3);
        mot_de_passe2 = findViewById(R.id.password4);
        verification = findViewById(R.id.verification);

        String mail = this.mail.getText().toString();
        String password1 = mot_de_passe1.getText().toString();

        verification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
performLogin();

            }
        });

    }

    private void performLogin() {

        String mail = this.mail.getText().toString();
        String password1 = mot_de_passe1.getText().toString();

        SharedPreferences preferences = getSharedPreferences("MesPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        if (!mail.matches(emailPattern)) {
            this.mail.setError("entrer une address email convenable");
        } else if (password1.isEmpty() || password1.length() < 6) {
            this.mot_de_passe1.setError("mot de passe incorect, merci de bien vouloir " +
                    "entrer un mot de passe conforme");
        } else {
            progressDialog.setMessage("merci de bien vouloir patienter  ...");
            progressDialog.setTitle("connexion");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            try {
                SharedPreferences preference = getSharedPreferences("User", MODE_PRIVATE);
                SharedPreferences.Editor donnee = preference.edit();
                donnee.putString("nom", nom.getText().toString());
                donnee.putString("phone", phone.getText().toString());
                donnee.putString("mail", mail.toString());
                donnee.putString("password", mot_de_passe1.getText().toString());
                donnee.apply();

                Intent acceuil = new Intent(this, MainActivity.class);
                acceuil.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                acceuil.putExtra("inscription","inscription");
                startActivity(acceuil);
                finish();
            } catch (NullPointerException e) {
                progressDialog.dismiss();
                Toast.makeText(Inscription.this, "Donnee incompatible ou inexistant", Toast.LENGTH_SHORT).show();
            }
        }

    }
}