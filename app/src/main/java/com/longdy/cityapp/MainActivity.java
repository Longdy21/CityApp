package com.longdy.cityapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter adapter;
    String cities[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        //String cities[] = {"Phnom Penh","KompongSom","Siem Reap"};
        //String cities = getProviceName();
        cities = getProviceName();
        //adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cities);
        //listView.setAdapter(adapter);

        adapter = new RowIconAdapter();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedProvince = cities[position];
                Location selectedLocation = loadLocationData().get(selectedProvince);
                Toast.makeText(getApplicationContext(), selectedLocation.toString(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, City_LatLongDetail.class);
                intent.putExtra("selected_province", selectedProvince);
                intent.putExtra("selected_location", selectedLocation);

                startActivity(intent);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    private HashMap<String, Location> loadLocationData() {
        HashMap<String, Location> locations = new HashMap<>();
        locations.put("PhnomPenh", new Location(11.5564, 104.9282));
        locations.put("Sihanouk", new Location(10.627543, 103.522141));
        locations.put("Kampot", new Location(10.594242, 104.164032));
        locations.put("Kampot", new Location(10.594242, 104.164032));
        locations.put("SiemReap", new Location(13.364047, 103.860313));
        locations.put("Battambang", new Location(13.028697, 102.989616));
        locations.put("Kampong Cham", new Location(11.99339, 105.4635));
        locations.put("Kampong Chhnang", new Location(12.25, 104.66667));
        locations.put("Kampong Thom", new Location(12.71112, 104.88873));
        locations.put("Koh Kong", new Location(11.61531, 102.9838));
        locations.put("Kep", new Location(10.48291, 104.31672));
        locations.put("Prey Veng", new Location(11.48682, 105.32533));
        locations.put("Takeo", new Location(10.99081, 104.78498));
        locations.put("Pursat", new Location(12.53878, 103.9192));
        locations.put("Mondolkiri", new Location(12.45583, 107.18811));
        locations.put("Stung Treng", new Location(13.52586, 105.9683));
        locations.put("Svay Rieng", new Location(11.08785, 105.79935));
        locations.put("Preah Vihear", new Location(13.80731, 104.98046));
        locations.put("Kandal", new Location(11.48333, 104.95));
        locations.put("Banteay Meanchey", new Location(13.58588, 102.97369));
        locations.put("Ratanakiri", new Location(13.73939, 106.98727));
        locations.put("Kampong Speu", new Location(11.45332, 104.52085));
        locations.put("Kratie", new Location(12.48811, 106.01879));
        locations.put("Pailin", new Location(12.84895, 102.60928));
        locations.put("Otâr Méanchey", new Location(14.18175, 103.51761));
        return locations;
    }

    private String[] getProviceName() {
        String[] provices = new String[loadLocationData().size()];
        provices = loadLocationData().keySet().toArray(provices);
        return provices;
    }

    //*
    private static class ViewHolder {
        TextView name;
        ImageView img;
    }

    class RowIconAdapter extends ArrayAdapter<String> {
        public RowIconAdapter() {
            super(MainActivity.this, R.layout.listrow, R.id.row_label, cities);
        }

        public View getView(int pos, View cView, ViewGroup parent) {
            String city = cities[pos];
            ViewHolder viewHolder;

            if (cView == null) {
                viewHolder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                cView = inflater.inflate(R.layout.listrow, parent, false);
                viewHolder.name = (TextView) cView.findViewById(R.id.row_label);
                viewHolder.img = (ImageView) cView.findViewById(R.id.row_icon);
                cView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) cView.getTag();
            }
            if(city.startsWith("PhnomPenh")){
                viewHolder.img.setImageResource(R.drawable.phnompenh);
            }else if(city.startsWith(("SiemReap"))){
                viewHolder.img.setImageResource(R.drawable.siemreap);
            }
/*
            Location location = loadLocationData().get(city);
            if (location != null) {
                double latitude = location.latitude;
                double longitude = location.longitude;

            // Check latitude and longitude to determine the correct image
            if (isInRange(latitude, 11.5564, 0.1) && isInRange(longitude, 104.9282, 0.1)) { // Phnom Penh
                viewHolder.img.setImageResource(R.drawable.phnompenh);
            } else if (isInRange(latitude, 10.627543, 0.1) && isInRange(longitude, 103.522141, 0.1)) { // Sihanouk
                viewHolder.img.setImageResource(R.drawable.sihanouk);
            } else if (isInRange(latitude, 10.594242, 0.1) && isInRange(longitude, 104.164032, 0.1)) { // Kampot
                viewHolder.img.setImageResource(R.drawable.kampot);
            } else if (isInRange(latitude, 13.364047, 0.1) && isInRange(longitude, 103.860313, 0.1)) { // Siem Reap
                viewHolder.img.setImageResource(R.drawable.siemreap);
            } else if (isInRange(latitude, 13.028697, 0.1) && isInRange(longitude, 102.989616, 0.1)) { // Battambang
                viewHolder.img.setImageResource(R.drawable.battambang);
            } else if (isInRange(latitude, 11.99339, 0.1) && isInRange(longitude, 105.4635, 0.1)) { // Kampong Cham
                viewHolder.img.setImageResource(R.drawable.kampongcham);
            } else if (isInRange(latitude, 12.25, 0.1) && isInRange(longitude, 104.66667, 0.1)) { // Kampong Chhnang
                viewHolder.img.setImageResource(R.drawable.kampongchhnang);
            } else if (isInRange(latitude, 12.71112, 0.1) && isInRange(longitude, 104.88873, 0.1)) { // Kampong Thom
                viewHolder.img.setImageResource(R.drawable.kampongthom);
            } else if (isInRange(latitude, 11.61531, 0.1) && isInRange(longitude, 102.9838, 0.1)) { // Koh Kong
                viewHolder.img.setImageResource(R.drawable.kohkong);
            } else if (isInRange(latitude, 10.48291, 0.1) && isInRange(longitude, 104.31672, 0.1)) { // Kep
                viewHolder.img.setImageResource(R.drawable.kep);
            } else if (isInRange(latitude, 11.48682, 0.1) && isInRange(longitude, 105.32533, 0.1)) { // Prey Veng
                viewHolder.img.setImageResource(R.drawable.preyveng);
            } else if (isInRange(latitude, 10.99081, 0.1) && isInRange(longitude, 104.78498, 0.1)) { // Takeo
                viewHolder.img.setImageResource(R.drawable.takeo);
            } else if (isInRange(latitude, 12.53878, 0.1) && isInRange(longitude, 103.9192, 0.1)) { // Pursat
                viewHolder.img.setImageResource(R.drawable.pursat);
            } else if (isInRange(latitude, 12.45583, 0.1) && isInRange(longitude, 107.18811, 0.1)) { // Mondolkiri
                viewHolder.img.setImageResource(R.drawable.mondolkiri);
            } else if (isInRange(latitude, 13.52586, 0.1) && isInRange(longitude, 105.9683, 0.1)) { // Stung Treng
                viewHolder.img.setImageResource(R.drawable.stungtreng);
            } else if (isInRange(latitude, 11.08785, 0.1) && isInRange(longitude, 105.79935, 0.1)) { // Svay Rieng
                viewHolder.img.setImageResource(R.drawable.svayrieng);
            } else if (isInRange(latitude, 13.80731, 0.1) && isInRange(longitude, 104.98046, 0.1)) { // Preah Vihear
                viewHolder.img.setImageResource(R.drawable.preahvihear);
            } else if (isInRange(latitude, 11.48333, 0.1) && isInRange(longitude, 104.95, 0.1)) { // Kandal
                viewHolder.img.setImageResource(R.drawable.kandal);
            } else if (isInRange(latitude, 13.58588, 0.1) && isInRange(longitude, 102.97369, 0.1)) { // Banteay Meanchey
                viewHolder.img.setImageResource(R.drawable.banteaymeanchey);
            } else if (isInRange(latitude, 13.73939, 0.1) && isInRange(longitude, 106.98727, 0.1)) { // Ratanakiri
                viewHolder.img.setImageResource(R.drawable.ratanakiri);
            } else if (isInRange(latitude, 11.45332, 0.1) && isInRange(longitude, 104.52085, 0.1)) { // Kampong Speu
                viewHolder.img.setImageResource(R.drawable.kampongspeu);
            } else if (isInRange(latitude, 12.48811, 0.1) && isInRange(longitude, 106.01879, 0.1)) { // Kratie
                viewHolder.img.setImageResource(R.drawable.kratie);
            } else if (isInRange(latitude, 12.84895, 0.1) && isInRange(longitude, 102.60928, 0.1)) { // Pailin
                viewHolder.img.setImageResource(R.drawable.pailin);
            } else if (isInRange(latitude, 14.18175, 0.1) && isInRange(longitude, 103.51761, 0.1)) { // Otâr Méanchey
                viewHolder.img.setImageResource(R.drawable.otarmeanchey);
            } */else {
                // Set a default image for cases not covered
                viewHolder.img.setImageResource(R.drawable.default_image);
            }
                viewHolder.name.setText(city);
                return cView;
            }

  /*          // Helper method to check if a value is within a certain range
            private boolean isInRange ( double value, double target, double range){
                return value >= target - range && value <= target + range;
            }

        }//*/
        }
    }