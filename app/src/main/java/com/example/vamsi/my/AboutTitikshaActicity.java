package com.example.vamsi.my;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class AboutTitikshaActicity extends AppCompatActivity {
    private Toolbar toolbar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_titiksha_acticity);
        toolbar2 = findViewById(R.id.about_toolbar);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

}
