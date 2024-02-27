package com.longdy.cityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class City_LatLongDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_lat_long_detail);

        TextView provinceTextView =(TextView) findViewById(R.id.provincetextView);
        TextView locationTextView =(TextView) findViewById(R.id.latlongtextView);
        ImageView  myImage = (ImageView) findViewById(R.id.myImage);

        // Retrieve the selected city details from the Intent
        Intent intent = getIntent();
        String selectedProvince = intent.getStringExtra("selected_province");
        Location selectedLocation = (Location) intent.getSerializableExtra("selected_location");

        // Display the selected city details in the CityDetailActivity
        if (selectedProvince != null && selectedLocation != null) {
            provinceTextView.setText(selectedProvince);
            locationTextView.setText(selectedLocation.toString());
        }
    }
}