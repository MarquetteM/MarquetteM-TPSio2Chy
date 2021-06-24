package fr.sio.boiteoutilschy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;

public class SaisieDate extends AppCompatActivity {
    private TextView displayHeure;
    private TextView displayDate;
    private Calendar heureSaisie;
    private Calendar dateSaisie;
    private String affTimDate;
    private NumberFormat format00;
    private int monthPlusUn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie_date);

        displayDate = (TextView) findViewById(R.id.affDate);
        displayHeure = (TextView) findViewById(R.id.affHeure);

        format00 = new DecimalFormat("00");

        //initialisation de la date et l'heure
        dateSaisie = Calendar.getInstance();
        monthPlusUn= dateSaisie.get(Calendar.MONTH) + 1;
        affTimDate = format00.format(dateSaisie.get(Calendar.DAY_OF_MONTH))+"/"+
                format00.format(monthPlusUn) + "/" +format00.format(dateSaisie.get(Calendar.YEAR));
        displayDate.setText(affTimDate);
        heureSaisie = Calendar.getInstance();
        affTimDate = format00.format(heureSaisie.get(Calendar.HOUR_OF_DAY)) + ":"+
                format00.format(heureSaisie.get(Calendar.MINUTE));
        displayHeure.setText(affTimDate);
    }

    public void saisieDate(View view){
        int annee = dateSaisie.get(Calendar.YEAR);
        int mois = dateSaisie.get(Calendar.MONTH);
        int jour = dateSaisie.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dateDial = new DatePickerDialog(
                SaisieDate.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mDateSetListener,
                annee, mois, jour);
        dateDial.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dateDial.show();
    }
    DatePickerDialog.OnDateSetListener mDateSetListener = (DatePicker arg0, int an, int mois, int jour) -> {
        dateSaisie.set(an, mois, jour);
        displayDate.setText(new StringBuilder().append(format00.format(jour)).append("/")
        .append(format00.format(mois)).append("/").append(format00.format(an)));
    };

    public void saisieHeure(View view){
        int heure = heureSaisie.get(Calendar.HOUR_OF_DAY);
        int minute = heureSaisie.get(Calendar.MINUTE);
        TimePickerDialog dateDial = new TimePickerDialog(
                SaisieDate.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mTimeSetListener,
                heure, minute, true);
        dateDial.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dateDial.show();
    }
    TimePickerDialog.OnTimeSetListener mTimeSetListener = (TimePicker arg0, int heure, int minute) -> {
        heureSaisie.set(0,0,0,heure, minute);
        displayHeure.setText(new StringBuilder().append(format00.format(heure)).append(":")
                .append(format00.format(minute)));
    };
}