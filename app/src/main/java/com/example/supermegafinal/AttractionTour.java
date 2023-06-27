package com.example.supermegafinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.yandex.mapkit.MapKitFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AttractionTour extends AppCompatActivity {
    private ListView attractionListViewTour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuor);
        attractionListViewTour = findViewById(R.id.attractionListViewTour);
        ArrayList<Attraction> attractions = getIntent().getParcelableArrayListExtra("attractions");
        AttractionManager attractionManager = new AttractionManager(Duration.ofMinutes(2));
        for (Attraction attraction: attractions){
            attractionManager.addAttraction(attraction);
        }
        ArrayList<Attraction> bestTour = attractionManager.getBestPathForTour();
        AttractionAdapter adapter = new AttractionAdapter(this, bestTour);
        attractionListViewTour.setAdapter(adapter);
        attractionListViewTour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Attraction attraction = (Attraction) parent.getItemAtPosition(position);

                Intent intent = new Intent(AttractionTour.this, AttractionDetailActivity.class);
                intent.putExtra("attractionName", attraction.getName());
                intent.putExtra("attractionDescription", attraction.getDescription());
                intent.putExtra("attractionLongDescription", attraction.getLongDescription());
                intent.putExtra("attractionLatitude", attraction.getLatitude());
                intent.putExtra("attractionLongitude", attraction.getLongitude());
                startActivity(intent);
            }
        });
    }

}

