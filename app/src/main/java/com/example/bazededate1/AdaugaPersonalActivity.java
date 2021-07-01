package com.example.bazededate1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TimePicker;
import android.widget.Toast;

public class AdaugaPersonalActivity extends AppCompatActivity {

    EditText nume;
    EditText functie;
    SeekBar nr_ore;
    TimePicker ora_tura;
    CheckBox e_angajat_vechi;

    Button btnSalveaza;
    AlertDialog alertDialog;

    public static final String ADD_PERSONAL = "adaugaPersonal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_personal);

        nume=findViewById(R.id.nume);
        functie=findViewById(R.id.functie);
        nr_ore=findViewById(R.id.seek_bar);
        ora_tura=findViewById(R.id.oraTura);
        e_angajat_vechi=findViewById(R.id.chech_box);

        btnSalveaza=findViewById(R.id.btnSalveaza);

        btnSalveaza.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if(nume.getText().toString().isEmpty())
                {
                    Toast.makeText(AdaugaPersonalActivity.this, R.string.error1,Toast.LENGTH_SHORT).show();
                }
                else if(functie.getText().toString().isEmpty() )
                {
                    Toast.makeText(AdaugaPersonalActivity.this, R.string.error2,Toast.LENGTH_SHORT).show();
                }
                else{
                    String txt_nume=nume.getText().toString();
                    String txt_functie=functie.getText().toString();
                    int txt_nr_ore_lucr=nr_ore.getProgress();
                    int txt_ora_tura=ora_tura.getHour();
                    boolean txt_ang_vechi=e_angajat_vechi.isChecked();

                    //intent
                    PersonalMedical personal = new PersonalMedical(txt_nume,txt_functie,txt_nr_ore_lucr,txt_ora_tura,txt_ang_vechi);
                    Intent intent = new Intent();
                    intent.putExtra("adaugaPersonal", personal);
                    //pt baza de date
                    PersonalDB personalDB=PersonalDB.getInstanta(getApplicationContext());
                    personalDB.getPersonalDao().insert(personal);
                    //
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}