package com.example.secd_q13;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button openMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        openMap = findViewById(R.id.openMap);

        openMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //specifing location (latitude, longitude)
                //an implicit intent is created with the geo: URI scheme.
                //geo:48.8584,2.2945 for the Eiffel Tower in Paris.
                //geo:40.7128,-74.0060 for New York City.
                String location = "geo:37.7749,-122.4194";

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));

                //making sure if there is an app that can handle this intent
                if(mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }

            }
        });

    }
}