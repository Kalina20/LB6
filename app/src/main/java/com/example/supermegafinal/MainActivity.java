package com.example.supermegafinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.yandex.mapkit.MapKitFactory;

public class MainActivity extends AppCompatActivity {
    private EditText lastNameEditText;
    private EditText firstNameEditText;
    private EditText emailEditText;
    private Button authorizeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        MapKitFactory.setApiKey("79b3eee2-2644-4aa9-b1d7-4090c3189d4f");

        lastNameEditText = findViewById(R.id.lastNameEditText);
        firstNameEditText = findViewById(R.id.firstNameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        authorizeButton = findViewById(R.id.authorizeButton);

        authorizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lastName = lastNameEditText.getText().toString();
                String firstName = firstNameEditText.getText().toString();
                String email = emailEditText.getText().toString();

                if (firstName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Заполните пж!!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(MainActivity.this, AttractionListActivity.class);
                intent.putExtra("ФИО", lastName);
                intent.putExtra("Никнейм", firstName);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
    }
}
