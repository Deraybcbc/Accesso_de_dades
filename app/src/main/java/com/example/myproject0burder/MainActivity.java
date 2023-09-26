package com.example.myproject0burder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("PRUEBA","He entrado");
        Log.d("KLK","MAR");

        CharSequence texto = "Vas a empezar el test";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this, texto, duration);
        toast.show();

        Button boton = (Button) findViewById(R.id.Boton);

        boton.setOnClickListener(this);
    }

    public boolean Verificar (RadioGroup...grup){
        boolean result = true;
        for (RadioGroup TotalBotones : grup){
            if (TotalBotones.getCheckedRadioButtonId() == -1) {
                result = false;
            }
        }

        return result;
    }

    public String OpcionSeleccionada(RadioGroup...grups){
        String imp ="";
        int cont = 1;
        for (RadioGroup respuestas : grups){
            int idRes = respuestas.getCheckedRadioButtonId();
            RadioButton boto = (RadioButton) findViewById(idRes);
            imp = imp + "Respuestas " + cont+": "+boto.getText().toString()+"\n";
            cont++;
        }
        return imp;
    }
    @Override
    public void onClick(View v) {
        RadioGroup pre1 = (RadioGroup) findViewById(R.id.Pregunta1);
        RadioGroup pre2 = (RadioGroup) findViewById(R.id.Pregunta2);
        RadioGroup pre3 = (RadioGroup) findViewById(R.id.Pregunta3);
        RadioGroup pre4 = (RadioGroup) findViewById(R.id.Pregunta4);
        RadioGroup pre5 = (RadioGroup) findViewById(R.id.Pregunta5);
        RadioGroup pre6 = (RadioGroup) findViewById(R.id.Pregunta6);
        RadioGroup pre7 = (RadioGroup) findViewById(R.id.Pregunta7);
        RadioGroup pre8 = (RadioGroup) findViewById(R.id.Pregunta8);
        RadioGroup pre9 = (RadioGroup) findViewById(R.id.Pregunta9);
        RadioGroup pre10 = (RadioGroup) findViewById(R.id.Pregunta10);

        if (Verificar(pre1,pre2,pre3,pre4,pre5,pre6,pre7,pre8,pre9,pre10) == false){
            CharSequence text = "Debe responderlas todas";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
        }
        else {
            CharSequence text = "ENVIADO";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
            Log.d("Respuestas",OpcionSeleccionada(pre1,pre2,pre3,pre4,pre5,pre6,pre7,pre8,pre9,pre10));
        }

    }
}