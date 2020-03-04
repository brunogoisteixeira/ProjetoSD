package app.bruno.minhacasa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
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
        final Switch desligaTudo = (Switch) findViewById(R.id.swDesligaTudo);
        TextView idTela = (TextView) findViewById(R.id.txtIdTela);

        //RECEBER DO QUARTO QUE DESEJO APAGAR A UZ
        Bundle receberId = getIntent().getExtras();
        if (receberId != null) {
            String id = receberId.getString("comodo");//RECEBO AQUI
            int valorConvertido = Integer.parseInt(id);//CONVERTO PARA INTEIRO
            //Toast.makeText(getApplicationContext(),"Estou na tela de id "+valorConvertido,Toast.LENGTH_LONG).show();
            switch (valorConvertido){ //APAO DE ACORDO COM O QUATO QUE EU QUERO
                case 1:
                    //Liga Luzes
                    idTela.setText("QUARTO PRINCIPAL");
                    luz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            final Button statusLuz = (Button) findViewById(R.id.btnEstadoLuz);

                            if (isChecked) {
                                statusLuz.setVisibility(View.VISIBLE);
                                thread a = new thread("1", "1");
                                a.start();
                                desligaTudo.setChecked(false);

                            } else {

                                thread a = new thread("0", "1");
                                a.start();
                                statusLuz.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                    break;
                case 2:
                    //Liga Luzes
                    idTela.setText("SEGUNDO QUARTO");
                    luz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            final Button statusLuz = (Button) findViewById(R.id.btnEstadoLuz);
                            if (isChecked) {
                                statusLuz.setVisibility(View.VISIBLE);
                                thread a = new thread("2", "1");
                                a.start();
                                desligaTudo.setChecked(false);
                            } else {
                                thread a = new thread("3", "1");
                                a.start();
                                statusLuz.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                    break;
                case 3:
                    //Liga Luzes
                    idTela.setText("TERCEIRO QUARTO");
                    luz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            final Button statusLuz = (Button) findViewById(R.id.btnEstadoLuz);
                            if (isChecked) {
                                statusLuz.setVisibility(View.VISIBLE);
                                thread a = new thread("4", "1");
                                a.start();
                                desligaTudo.setChecked(false);
                            } else {
                                thread a = new thread("5", "1");
                                a.start();
                                statusLuz.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                    break;
                case 4:
                    //Liga Luzes
                    idTela.setText("SALA DE TV");
                    luz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            final Button statusLuz = (Button) findViewById(R.id.btnEstadoLuz);
                            if (isChecked) {
                                statusLuz.setVisibility(View.VISIBLE);
                                thread a = new thread("6", "1");
                                a.start();
                                desligaTudo.setChecked(false);
                            } else {
                                thread a = new thread("7", "1");
                                a.start();
                                statusLuz.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                    break;
                case 5:
                    //Liga Luzes
                    idTela.setText("SALA DE JANTAR");
                    luz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            final Button statusLuz = (Button) findViewById(R.id.btnEstadoLuz);
                            if (isChecked) {
                                statusLuz.setVisibility(View.VISIBLE);
                                thread a = new thread("8", "1");
                                a.start();
                                desligaTudo.setChecked(false);
                            } else {
                                thread a = new thread("9", "1");
                                a.start();
                                statusLuz.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                    break;
                case 6:
                    idTela.setText("SALA DE ESTUDOS");
                    Toast.makeText(getApplicationContext(),"OPÇÃO AINDA NÃO IMPLEMENTADA ",Toast.LENGTH_SHORT).show();
                    break;
                case 7:
                    idTela.setText("COZINHA");
                    Toast.makeText(getApplicationContext(),"OPÇÃO AINDA NÃO IMPLEMENTADA ",Toast.LENGTH_SHORT).show();
                    break;
                case 8:
                    idTela.setText("BANHEIRO PRINCIPAL");
                    Toast.makeText(getApplicationContext(),"OPÇÃO AINDA NÃO IMPLEMENTADA ",Toast.LENGTH_SHORT).show();
                    break;
                case 9:
                    idTela.setText("BANHEIRO SWITCH");
                    //Toast.makeText(getApplicationContext(),"OPÇÃO AINDA NÃO IMPLEMENTADA ",Toast.LENGTH_SHORT).show(;)
                    break;


            }

        //Liga Tomadas
        tomadas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Button statusTomadas = (Button) findViewById(R.id.btnEstadoTomada);
                if (isChecked) {
                    statusTomadas.setVisibility(View.VISIBLE);
                    desligaTudo.setChecked(false);
                } else {
                    statusTomadas.setVisibility(View.INVISIBLE);
                }
            }
        });
        //Liga Ventilador
        ventilador.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Button statusVentilador = (Button) findViewById(R.id.btnEstadoVentilador);
                statusVentilador.setVisibility(View.INVISIBLE);
                if (isChecked) {
                    statusVentilador.setVisibility(View.VISIBLE);
                } else {
                    statusVentilador.setVisibility(View.INVISIBLE);
                }
            }
        });

        //Desligar tudo
        desligaTudo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    luz.setChecked(false);
                    tomadas.setChecked(false);
                    ventilador.setChecked(false);
                    portas.setChecked(false);
                    Toast.makeText(getApplicationContext(), "Todos os aparelhos estão desligados", Toast.LENGTH_LONG).show();
                }
            }
        });

        portas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Button porta = (Button) findViewById(R.id.btnEstadoPorta);
                if (isChecked) {
                    porta.setVisibility(View.VISIBLE);
                } else {
                    porta.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

    }
}
