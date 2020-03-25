package app.bruno.minhacasa;


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

    public static String Status;
    int quantidadeAparelhos = 0;
    String converterQuantidadeAparelhos = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liga_desliga);

        final ToggleButton luz = (ToggleButton) findViewById(R.id.tbLuz);
        final ToggleButton tomadas = (ToggleButton) findViewById(R.id.tbTomadas);
        final ToggleButton ventilador = (ToggleButton) findViewById(R.id.tbVentilador);
        final ToggleButton portas = (ToggleButton) findViewById(R.id.tbPortas);
        final Switch desligaTudo = (Switch) findViewById(R.id.swDesligaTudo);
        final TextView idTela = (TextView) findViewById(R.id.txtIdTela);




        threadClienteBroadCastServidor m = new threadClienteBroadCastServidor("A");
       // m.run();
        try{
           /// Thread.sleep(2000);
           // m.join();
            //      Toast.makeText(getBaseContext(),"Entrei1 ",Toast.LENGTH_LONG).show();

        }catch (Exception e ){

        }





        //Valor do status separdo pelo split
       /* String array[] = Status.split(";");
        Toast.makeText(getApplicationContext(),"Array na posição "+Status,Toast.LENGTH_LONG).show();


        if(array[0].equalsIgnoreCase("1")){
            luz.setChecked(true);
        }else{
            luz.setChecked(false);
        }
        if(array[1].equalsIgnoreCase("2")){
            ligarLed2.setChecked(true);
        }else{
            ligarLed2.setChecked(false);
        }
        if(array[2].equalsIgnoreCase("4")){
            ligarLed3.setChecked(true);
        }else{
            ligarLed3.setChecked(false);
        }
        if(array[3].equalsIgnoreCase("6")){
            ligarLed4.setChecked(true);
        }else{
            ligarLed4.setChecked(false);
        }*/



        //RECEBER DO QUARTO QUE DESEJO APAGAR A UZ
        Bundle receberId = getIntent().getExtras();
        if (receberId != null) {
            String id = receberId.getString("comodo");//RECEBO AQUI
            int valorConvertido = Integer.parseInt(id);//CONVERTO PARA INTEIRO
            //Toast.makeText(getApplicationContext(),"Estou na tela de id "+valorConvertido,Toast.LENGTH_LONG).show();
            switch (valorConvertido){ //APAO DE ACORDO COM O QUATO QUE EU QUERO
                case 1:
                    //final String array[] = Status.split(";");//Separo o split aqui
                    //Liga Luzes
                    idTela.setText("QUARTO PRINCIPAL");
                    luz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            final Button statusLuz = (Button) findViewById(R.id.btnEstadoLuz);

                            if ((isChecked) ) {//&& (array[0].equalsIgnoreCase("1"))
                                quantidadeAparelhos++;
                                luz.setChecked(true);
                                statusLuz.setVisibility(View.VISIBLE);
                                classThreadConexao a = new classThreadConexao("1","5");
                                //Lista.add(new ComodosCasa("Quarto Principal",R.drawable.ic_quarto,"4 Aparelhos","28º"));
                                a.start();
                                desligaTudo.setChecked(false);

                            } else {
                                quantidadeAparelhos = 0;
                                classThreadConexao a = new classThreadConexao("0","5");
                                a.start();
                                luz.setChecked(false);
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
                                classThreadConexao a = new classThreadConexao("2", "1");
                                a.start();
                                desligaTudo.setChecked(false);
                            } else {
                                classThreadConexao a = new classThreadConexao("3", "1");
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
                                classThreadConexao a = new classThreadConexao("4", "1");
                                a.start();
                                desligaTudo.setChecked(false);
                            } else {
                                classThreadConexao a = new classThreadConexao("5", "1");
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
                                classThreadConexao a = new classThreadConexao("6", "1");
                                a.start();
                                desligaTudo.setChecked(false);
                            } else {
                                classThreadConexao a = new classThreadConexao("7", "1");
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
                                classThreadConexao a = new classThreadConexao("8", "1");
                                a.start();
                                desligaTudo.setChecked(false);
                            } else {
                                classThreadConexao a = new classThreadConexao("9", "1");
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
