package com.example.magoua;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<Drawable> imageList = new ArrayList<>();
        imageList.add(getResources().getDrawable(R.drawable.g12));
        imageList.add(getResources().getDrawable(R.drawable.g2));
        imageList.add(getResources().getDrawable(R.drawable.g3));
        imageList.add(getResources().getDrawable(R.drawable.g4));
        imageList.add(getResources().getDrawable(R.drawable.g5));
        imageList.add(getResources().getDrawable(R.drawable.g2));
        imageList.add(getResources().getDrawable(R.drawable.g6));
        imageList.add(getResources().getDrawable(R.drawable.g7));
        imageList.add(getResources().getDrawable(R.drawable.g8));
        imageList.add(getResources().getDrawable(R.drawable.g9));
        imageList.add(getResources().getDrawable(R.drawable.g13));


        imageList.add(getResources().getDrawable(R.drawable.m1));
        imageList.add(getResources().getDrawable(R.drawable.m2));
        imageList.add(getResources().getDrawable(R.drawable.m3));
        imageList.add(getResources().getDrawable(R.drawable.m4));
        imageList.add(getResources().getDrawable(R.drawable.m5));
        imageList.add(getResources().getDrawable(R.drawable.m6));
        imageList.add(getResources().getDrawable(R.drawable.m7));
        imageList.add(getResources().getDrawable(R.drawable.m8));
        imageList.add(getResources().getDrawable(R.drawable.m9));
        imageList.add(getResources().getDrawable(R.drawable.m11));
        imageList.add(getResources().getDrawable(R.drawable.m12));
        RecyclerView recyclerView = findViewById(R.id.receptacle);
       ImagePublicationAdapter adapter = new ImagePublicationAdapter(imageList,this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}