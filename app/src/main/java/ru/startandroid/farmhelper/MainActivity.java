package ru.startandroid.farmhelper;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText userField1;
    private EditText userField2;
    private Button resultButton;
    private Button resetButton;
    private TextView resultInfo;
    private Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        userField1 = findViewById(R.id.userField1);
        userField2 = findViewById(R.id.userField2);
        resultButton = findViewById(R.id.resultButton);
        resetButton = findViewById(R.id.resetButton);
        resultInfo = findViewById(R.id.resultInfo);
        exitButton = findViewById(R.id.exitButton);

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float firstValue = Float.parseFloat(userField1.getText().toString());
                float secondValue = Float.parseFloat(userField2.getText().toString());
                float result = firstValue * secondValue * secondValue * 0.000082956f;

                DecimalFormat decimalFormat = new DecimalFormat("#.#");

                resultInfo.setText(decimalFormat.format(result) + " кг");
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userField1.setText("");
                userField2.setText("");
                resultInfo.setText("");
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAndRemoveTask();
            }
        });

        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
    }
}