package app.bruno.minhacasa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.lang.reflect.Parameter;

public class TelaControleDispositivos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_controle_dispositivos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textView = (TextView) findViewById(R.id.txtComodo);
        final ImageButton imageButton = (ImageButton)findViewById(R.id.imvLampada);
        final ToggleButton toggleButton = (ToggleButton)findViewById(R.id.tbAcendeApaga);
        Button botao2 = (Button) findViewById(R.id.btnApaga);
        final Button botao = (Button) findViewById(R.id.btnAcende);
        final Switch sw = (Switch) findViewById(R.id.swLampada);


        final RadioButton radioButton1 = (RadioButton)findViewById(R.id.rbLiga);
        final RadioButton radioButton2 = (RadioButton)findViewById(R.id.rbDesliga);

        Intent intent = getIntent();
        String comodo = (String) intent.getSerializableExtra("comodo");
        textView.setText("Controlar "+comodo);

        if(radioButton1.isChecked() == true){
            imageButton.setVisibility(View.VISIBLE);
            toggleButton.setChecked(true);
            sw.setChecked(true);
            radioButton1.setChecked(true);
            Toast.makeText(getBaseContext(),"Luz Acesa ", Toast.LENGTH_SHORT).show();
        }if(radioButton2.isChecked() == true){
            imageButton.setVisibility(View.INVISIBLE);
            toggleButton.setChecked(false);
            radioButton2.setChecked(false);
            sw.setChecked(false);
            Toast.makeText(getBaseContext(),"Luz Apagada ", Toast.LENGTH_SHORT).show();
        }


        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    imageButton.setVisibility(View.VISIBLE);
                    toggleButton.setChecked(true);
                    sw.setChecked(true);
                    radioButton1.setChecked(true);

                Toast.makeText(getBaseContext(),"Luz Acesa ", Toast.LENGTH_SHORT).show();
            }
        });


        botao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton.setVisibility(View.INVISIBLE);
                toggleButton.setChecked(false);
                sw.setChecked(false);
                radioButton2.setChecked(true);
                Toast.makeText(getBaseContext(),"Luz Apagada ", Toast.LENGTH_SHORT).show();
            }
        });



        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked ){
                    imageButton.setVisibility(View.VISIBLE);
                    sw.setChecked(true);
                    radioButton1.setChecked(true);
                    Toast.makeText(getBaseContext(),"Luz Acesa ", Toast.LENGTH_SHORT).show();
                }else{
                    imageButton.setVisibility(View.INVISIBLE);
                    toggleButton.setChecked(false);
                    radioButton2.setChecked(true);
                    sw.setChecked(false);
                    Toast.makeText(getBaseContext(),"Luz Apagada ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    imageButton.setVisibility(View.VISIBLE);
                    toggleButton.setChecked(true);
                    radioButton1.setChecked(true);
                    Toast.makeText(getBaseContext(),"Luz Acesa ", Toast.LENGTH_SHORT).show();
                }else{
                    imageButton.setVisibility(View.INVISIBLE);
                    toggleButton.setChecked(false);
                    radioButton2.setChecked(true);
                    Toast.makeText(getBaseContext(),"Luz Apagada ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
