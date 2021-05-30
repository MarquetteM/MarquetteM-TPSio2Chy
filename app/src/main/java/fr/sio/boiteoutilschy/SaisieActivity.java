package fr.sio.boiteoutilschy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SaisieActivity extends AppCompatActivity {
    private Intent intent;
    private EditText textSaisi;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie);

        textSaisi = findViewById(R.id.textsaisi);
    }

    public void valider (View V){
        //transfert le texte saisi à l'activité principale
        intent = new Intent(SaisieActivity.this, MainActivity.class);
        intent.putExtra("texteSaisi", textSaisi.getText().toString());
        Log.i("BTO","Page saisie");
        startActivity(intent);
    }

    public void annuler (View V) {
        //annule l'opération retour à la page principale
        intent = new Intent(SaisieActivity.this, MainActivity.class);
        startActivity(intent);
    }
}