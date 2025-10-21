package com.example.a2praktinis;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

// Visi kintamieji, metodai ir klasės pavadinimai anglų kalba

public class MainActivity extends AppCompatActivity {

    private EditText textToCountEditText;
    private Spinner calculationTypeSpinner;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Susiejame UI elementus pagal ID
        textToCountEditText = findViewById(R.id.textToCountEditText);
        calculationTypeSpinner = findViewById(R.id.calculationTypeSpinner);
        resultTextView = findViewById(R.id.resultTextView);

    }

    /**
     * Iškviečiama paspaudus mygtuką "Count" (android:onClick="onCountButtonClick").
     * @param view Mygtuko View elementas.
     */
    public void onCountButtonClick(View view) {
        // Paimame tekstą iš EditText ir pašaliname pradinius/galinius tarpus patikrinimui
        String input = textToCountEditText.getText().toString();

        // Programėlė turi tikrinti įvedamą tekstą (ar laukas nėra tuščias)
        if (input.trim().isEmpty()) {
            // Parodome pranešimą, naudojant Toast
            Toast.makeText(this, R.string.empty_input_error, Toast.LENGTH_SHORT).show();
            // Nutraukiame vykdymą, jei tekstas tuščias
            return;
        }

        // Gauname pasirinktą parinktį iš Spinner
        String selectedOption = calculationTypeSpinner.getSelectedItem().toString();
        int result = 0;

        // Skaičiavimo logika
        String wordsOption = getString(R.string.words_option);

        // 7. Žodžių/ženklų skaičiavimas atliekamas atskiroje klasėje (Calculator)
        if (selectedOption.equals(wordsOption)) {
            // Skaičiuojame žodžius
            result = Calculator.countWords(input);
        } else { // Jei pasirinkta "Characters" (ženklai)
            // Skaičiuojame ženklus
            result = Calculator.countCharacters(input);
        }

        // Rezultatas parodomas naudojant TextView tipo elementą
        String resultText = getString(R.string.result_prefix) + result;
        resultTextView.setText(resultText);
    }
}