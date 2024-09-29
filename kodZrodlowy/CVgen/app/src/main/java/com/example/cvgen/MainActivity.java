package com.example.cvgen;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout; // Importujemy ConstraintLayout
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Znajdujemy layout o id 'main', teraz jest to ConstraintLayout
        ConstraintLayout mainLayout = findViewById(R.id.main); // Zmieniamy LinearLayout na ConstraintLayout

        // Ustawiamy kolor tła dynamicznie
        int color = ContextCompat.getColor(this, R.color.tlo);
        mainLayout.setBackgroundColor(color);

        // Ustawienie wcięć systemowych
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
