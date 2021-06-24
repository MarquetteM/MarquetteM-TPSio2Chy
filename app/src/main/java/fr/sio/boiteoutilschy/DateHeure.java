package fr.sio.boiteoutilschy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class DateHeure extends AppCompatActivity {
    private Intent intent;
    private TextView displayHeure;
    private TextView displayDate;
    private Calendar calend;
    private String aff;
    private DatePickerDialog.OnDateSetListener mmDateSetListener;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_heure);

        //Page de saisie d'une date et d'une heure
        displayDate = (TextView) findViewById(R.id.affDate);
        displayHeure = (TextView) findViewById(R.id.affHeure);

        calend = Calendar.getInstance();
        aff = calend.get(Calendar.DAY_OF_MONTH) + "/" +calend.get(Calendar.MONTH)+1 + "/" + calend.get(Calendar.YEAR);
        displayDate.setText(aff);
        aff = calend.get(Calendar.HOUR_OF_DAY) + ":" + calend.get(Calendar.MINUTE);
        displayHeure.setText(aff);
    }

    public void retour(View view) {
    }
}