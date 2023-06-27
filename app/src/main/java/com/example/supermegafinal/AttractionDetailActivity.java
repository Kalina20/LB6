package com.example.supermegafinal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;



public class AttractionDetailActivity extends AppCompatActivity {
    private TextView attractionTextView;
    private String attraction;

    private double attractionLatitude;
    private double attractionLongitude;

    private String attractionLongDescription;

    private MapView mapview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_detail);


        Intent intent = getIntent();
        if (intent != null) {
            String attractionName = intent.getStringExtra("attractionName");
            String attractionDescription = intent.getStringExtra("attractionDescription");
            attractionLongDescription = intent.getStringExtra("attractionLongDescription");
            attractionLatitude = intent.getDoubleExtra("attractionLatitude", 0.0);
            attractionLongitude = intent.getDoubleExtra("attractionLongitude", 0.0);}

        MapKitFactory.initialize(this);

        mapview = (MapView)findViewById(R.id.mapview);
        mapview.getMap().move(
                new CameraPosition(new Point(attractionLatitude, attractionLongitude), 11.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 0),
                null);
        mapview.getMap().getMapObjects().addPlacemark(new Point(attractionLatitude, attractionLongitude));

        attractionTextView = findViewById(R.id.attractionTextView);

        attraction = getIntent().getStringExtra("attraction");
        attractionTextView.setText(attractionLongDescription);


    }


    @Override
    protected void onStop() {
        mapview.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapview.onStart();
    }
}
