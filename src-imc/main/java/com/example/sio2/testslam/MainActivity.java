package com.example.sio2.testslam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Spinner;
import android.text.Editable;
import android.text.TextWatcher;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;


import android.widget.Toast;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends Activity implements View.OnClickListener {
    private Button btn,btn2;
    private int count;
    private TextView nom;
    private String lenom;
    private String leprenom;
    private TextView prenom;
    private TextView poids;
    private TextView taille;
    private String lataille;
    private String lepoids;
    private Spinner jourNai;
    private Spinner moisNai;
    private TextView anneeNai;
    private String lejourNai;
    private String lemoisNai;
    private String lanneeNai;
    private float calculpoids=0;
    private float calcultaille=0;
    private float total;
    private String test;
    private int anneeauj;
    private int moisauj;
    private int jourauj;
    private int calculannee;
    private int calculmois;
    private int age;
    private String imc;
    private int calculjour;
    private String interpretation;
    Calendar calendar = new GregorianCalendar();
    Date date = new Date();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.premier);
        btn.setOnClickListener(this);

        btn2 = (Button) findViewById(R.id.second);
        btn2.setOnClickListener(this);



    }

    TextWatcher watch = new TextWatcher(){
        @Override
        public void afterTextChanged(Editable arg0) {

        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

        }

        @Override
        public void onTextChanged(CharSequence s, int a, int b, int c) {


        }};









    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.second:

                poids = (TextView) findViewById(R.id.field7);
                poids.setText("");

                taille = (TextView) findViewById(R.id.field8);
                taille.setText("");



                anneeNai = (TextView) findViewById(R.id.field9);
                anneeNai.setText("");

                break;
            case R.id.premier:



        nom = (TextView) findViewById(R.id.field2);
        lenom  = nom.getText().toString();

        prenom = (TextView) findViewById(R.id.field4);
        leprenom  = prenom.getText().toString();

        poids = (TextView) findViewById(R.id.field7);
        lepoids  = poids.getText().toString();

        taille = (TextView) findViewById(R.id.field8);
        lataille  = taille.getText().toString();

        jourNai = (Spinner) findViewById(R.id.spinner);
        lejourNai  = jourNai.getSelectedItem().toString();

        moisNai = (Spinner) findViewById(R.id.spinner2);
        lemoisNai  = moisNai.getSelectedItem().toString();

        anneeNai = (TextView) findViewById(R.id.field9);
        lanneeNai  = anneeNai.getText().toString();

        if(lanneeNai.length()==0){
            Toast.makeText(getApplicationContext(), "Année non valide !", Toast.LENGTH_SHORT).show();
        }else {
            if(lepoids.length()==0){
                Toast.makeText(getApplicationContext(), "Poids non valide !", Toast.LENGTH_SHORT).show();
            }else{
                if(lataille.length()==0) {
                    Toast.makeText(getApplicationContext(), "Taille non valide !", Toast.LENGTH_SHORT).show();
                }else{


            //calcul age
            calendar.setTime(date);
            anneeauj = calendar.get(Calendar.YEAR);
            moisauj = calendar.get(Calendar.MONTH);
            jourauj = calendar.get(Calendar.DAY_OF_MONTH);

            calculannee = Integer.parseInt(lanneeNai);
            calculmois = Integer.parseInt(lemoisNai);
            calculjour = Integer.parseInt(lejourNai);


            if (moisauj >= calculmois) {
                if (moisauj > calculmois) {
                    age = anneeauj - calculannee;
                } else {
                    if (jourauj < calculjour) {
                        age = anneeauj - calculannee - 1;
                    } else {
                        age = anneeauj - calculannee;
                    }
                }

            } else {
                age = anneeauj - calculannee - 1;
            }




        //fin calcul age


        //calcul IMC

        calculpoids = Float.parseFloat(lepoids);
        calcultaille = Float.parseFloat(lataille);

        if (age >= 18) {
            total = calculpoids / (calcultaille * calcultaille);

            //interpretation

            if (total < 16.5)
            {
                interpretation = " / Famine";
            }
            if(16.5 <= total && total < 18.5){
                interpretation = " / maigreur";
            }
            if(18.5 <= total && total < 25){
                interpretation = " / corpulence normale";
            }
            if(25 <= total && total < 30){
                interpretation= " / surpoids";
            }
            if(30 <= total && total < 35){
                interpretation= " / obésité modérée";
            }
            if(35 <= total && total <= 40){
                interpretation= " / obésitée sévère";
            }
            if (total > 40)
            {
                interpretation =" / obésité morbide ou massive";
            }



            // fin interpretation
            imc = Float.toString(total) + interpretation;

        }
        else {
            imc = "non représentatif pour un enfant";
        }


        //fin calcul IMC



        test = lenom + " " + leprenom + "\n" + "Poids : " + lepoids + "\n" + "Taille : " + lataille + "\n" + " âge : " + age + "\n" + "IMC : " + imc ;


        Toast.makeText(getApplicationContext(), test, Toast.LENGTH_SHORT).show();

                }
            }
        }
                break;}
    }

}

