package app.bruno.minhacasa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ActivityLigaDesliga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liga_desliga);

        final ToggleButton luz = (ToggleButton) findViewById(R.id.tbLuz);
        final ToggleButton tomadas = (ToggleButton) findViewById(R.id.tbTomadas);
        final ToggleButton ventilador = (ToggleButton) findViewById(R.id.tbVentilador);
        final ToggleButton portas = (ToggleButton) findViewById(R.id.tbPortas);
        final Switch desligaTudo = (Switch)findViewById(R.id.swDesligaTudo);

        //Liga Luzes
        luz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                final Button statusLuz = (Button)findViewById(R.id.btnEstadoLuz);
                if(isChecked){
                    statusLuz.setVisibility(View.VISIBLE);

                   // thread a = new thread("0","1");
                  //  a.start();


                    desligaTudo.setChecked(false);
                }else{
                    statusLuz.setVisibility(View.INVISIBLE);
                }
            }
        });
        //Liga Tomadas
        tomadas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Button statusTomadas = (Button)findViewById(R.id.btnEstadoTomada);
                if(isChecked){
                    statusTomadas.setVisibility(View.VISIBLE);
                    desligaTudo.setChecked(false);
                }else{
                    statusTomadas.setVisibility(View.INVISIBLE);
                }
            }
        });
        //Liga Ventilador
        ventilador.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Button statusVentilador = (Button)findViewById(R.id.btnEstadoVentilador);
                statusVentilador.setVisibility(View.INVISIBLE);
                if(isChecked){
                    statusVentilador.setVisibility(View.VISIBLE);
                }else{
                    statusVentilador.setVisibility(View.INVISIBLE);
                }
            }
        });

        //Desligar tudo
        desligaTudo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    luz.setChecked(false);
                    tomadas.setChecked(false);
                    ventilador.setChecked(false);
                    portas.setChecked(false);
                    Toast.makeText(getApplicationContext(),"Todos os aparelhos estão desligados",Toast.LENGTH_LONG).show();
                }
            }
        });

        portas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Button porta = (Button)findViewById(R.id.btnEstadoPorta);
                if(isChecked){
                    porta.setVisibility(View.VISIBLE);
                }else{
                    porta.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
}
