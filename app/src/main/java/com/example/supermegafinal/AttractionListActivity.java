package com.example.supermegafinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.time.Duration;
import java.util.ArrayList;

public class AttractionListActivity extends AppCompatActivity {
    private ListView attractionListView;

    private Button buttonTour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_list);

        attractionListView = findViewById(R.id.attractionListView);
        ArrayList<Attraction> attractions = new ArrayList<>();
        buttonTour = findViewById(R.id.buttonTour);
        attractions.add(new Attraction("Красная площадь", "Москва","Это Красная площадь", 55.754947472890095, 37.62088076971179 , Duration.ofMinutes(50)));
        attractions.add(new Attraction("Пушкинский музей", "Москва","Это музей", 55.74378012405179, 37.59715991558662 , Duration.ofMinutes(50)));
        attractions.add(new Attraction("Собо́р Васи́лия Блаже́нного ", "Москва", "Это Собо́р Васи́лия Блаже́нного", 55.7526436299209, 37.62308679740778 , Duration.ofMinutes(50)));
        attractions.add(new Attraction("Московский Кремль ", "Москва", "Это Московский Кремль", 55.75216214519257, 37.61737065138538 , Duration.ofMinutes(50)));
        attractions.add(new Attraction("Московский Государственный Объединенный Музей-Заповедник ", "Москва","Это Московский Государственный Объединенный Музей-Заповедник ", 55.672508329618076, 37.66509462439173 , Duration.ofMinutes(50)));
        attractions.add(new Attraction("Большой театр", "Москва","Это Большой театр", 55.76006706962619, 37.619077750816174 , Duration.ofMinutes(50)));
        attractions.add(new Attraction("Универмаг ГУМ ", "Москва", "Это Универмаг ГУМ", 55.75481138569877, 37.621478681955736 , Duration.ofMinutes(50)));
        attractions.add(new Attraction("PANORAMA360 ", "Москва", "Это PANORAMA360", 55.750283851881825, 37.53783555126426 , Duration.ofMinutes(50)));
        attractions.add(new Attraction("Выставка достижений народного хозяйства", "Москва","Это Выставка достижений народного хозяйства", 55.83351502889289, 37.62879046225317 , Duration.ofMinutes(50)));
        attractions.add(new Attraction("Храм Христа Спасителя", "Москва","Это Храм Христа Спасителя", 55.744776371485834, 37.6054938973008, Duration.ofMinutes(50)));
        attractions.add(new Attraction("Крутицкое подворье ", "Москва", "Это Крутицкое подворье", 55.72807266454749, 37.65809068035292, Duration.ofMinutes(50)));
        attractions.add(new Attraction("Московский государственный университет ", "Москва", "Это Московский государственный университет", 55.73832202638525, 37.622296381287136, Duration.ofMinutes(50)));

        AttractionAdapter adapter = new AttractionAdapter(this, attractions);
        attractionListView.setAdapter(adapter);

        attractionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Attraction attraction = (Attraction) parent.getItemAtPosition(position);

                Intent intent = new Intent(AttractionListActivity.this, AttractionDetailActivity.class);
                intent.putExtra("attractionName", attraction.getName());
                intent.putExtra("attractionDescription", attraction.getDescription());
                intent.putExtra("attractionLongDescription", attraction.getLongDescription());
                intent.putExtra("attractionLatitude", attraction.getLatitude());
                intent.putExtra("attractionLongitude", attraction.getLongitude());
                startActivity(intent);
            }
        });


        String FIO = getIntent().getStringExtra("ФИО");
        String Nicname = getIntent().getStringExtra("Никнейм");
        String email = getIntent().getStringExtra("email");

        Toast.makeText(this, "Здравствуй " + Nicname + "!", Toast.LENGTH_SHORT).show();

        buttonTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AttractionListActivity.this, AttractionTour.class);
                intent.putParcelableArrayListExtra("attractions", attractions);
                startActivity(intent);
            }
        });

    }

}
