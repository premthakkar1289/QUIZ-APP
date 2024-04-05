package com.example.quizz;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DemoHoomeActivity extends AppCompatActivity {

    ArrayList<DemoContactModel> arr = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_hoome);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arr.add(new DemoContactModel(R.drawable.a,"12435667"));
        arr.add(new DemoContactModel(R.drawable.b,"12435667"));

        DemoRecyclerAdapter apadter = new DemoRecyclerAdapter(this,arr);
        recyclerView.setAdapter(apadter);

    }
}