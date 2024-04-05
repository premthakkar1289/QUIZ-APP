package com.example.quizz;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.quizz.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    Spinner spinner;
    Button btn1,btn2;
    public static final String[] languages = {"", "English", "Hindi"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<CategoryModel> categories = new ArrayList<>();
        categories.add(new CategoryModel("","Mathematics",""));
        categories.add(new CategoryModel("","Science",""));
        categories.add(new CategoryModel("","Computer",""));

        CategoryAdapter adapter1 = new CategoryAdapter(this,categories);
//        binding.categoryList.setLayoutManager(new GridLayoutManager(this,2));
//        binding.categoryList.setAdapter(adapter1);


        btn1 = findViewById(R.id.submitBtn);
        btn2 = findViewById(R.id.loginBtn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DemoHoomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        spinner = findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("UnsafeIntentLaunch")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selectedLang = parent.getItemAtPosition(position).toString();

                if (selectedLang.equals("English")) {

                    setLocal(MainActivity.this, "en");
                    finish();
                    startActivity(getIntent());

                } else if (selectedLang.equals("Hindi")) {
                    setLocal(MainActivity.this, "hi");
                    finish();
                    startActivity(getIntent());
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }

    public void setLocal(Activity activity, String langCode) {

        Locale locale = new Locale(langCode);
        locale.setDefault(locale);
        Resources resources = activity.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());


    }
}