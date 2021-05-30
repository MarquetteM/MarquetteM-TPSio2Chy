package fr.sio.boiteoutilschy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtSaisi;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSaisi = findViewById(R.id.saisieTexte);

        intent = getIntent();
        if (intent.hasExtra("texteSaisi")) {
            String texteRecu = intent.getStringExtra("texteSaisi");
            Log.i("BTO",texteRecu);
            txtSaisi.setText(texteRecu);
        }
    }

    public void saisieText(View v) {
        //Lance l'activité saisie
        intent = new Intent(MainActivity.this, SaisieActivity.class );
        startActivity(intent);
    }

}