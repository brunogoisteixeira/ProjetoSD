package app.bruno.minhacasa;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ComodosCasa> Lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ListView listaComodos = (ListView) findViewById(R.id.idListaComodos);

        Lista = new ArrayList<ComodosCasa>();
        Lista.add(new ComodosCasa("Quarto Principal",R.drawable.ic_quarto,"4 Aparelhos","28º"));
        //Lista.add(new ComodosCasa("Quarto 01",R.drawable.quarto01,"12 Aparelhos","28º"));
        Lista.add(new ComodosCasa("Quarto 02",R.drawable.quarto02,"12 Aparelhos","28º"));
        Lista.add(new ComodosCasa("Quarto 03",R.drawable.quarto03,"15 Aparelhos","28º"));
        Lista.add(new ComodosCasa("Sala de TV",R.drawable.salatv,"10 Aparelhos","25º"));
        Lista.add(new ComodosCasa("Sala de Jantar",R.drawable.salajantar,"8 Aparelhos","28º"));
        Lista.add(new ComodosCasa("Sala de Estudos",R.drawable.salaestudos,"6 Aparelhos","28º"));
        Lista.add(new ComodosCasa("Cozinha",R.drawable.cozinha02,"6 Aparelhos","28º"));
        Lista.add(new ComodosCasa("Banheiro 01",R.drawable.banheiro,"4 Aparelhos","28º"));
        Lista.add(new ComodosCasa("Banheiro Switch",R.drawable.banheiroswitc,"6 Aparelhos","28º"));
        Lista.add(new ComodosCasa("Garagem",R.drawable.garagem," Aparelhos","28º"));
        Lista.add(new ComodosCasa("Sala de Estudos",R.drawable.lavanderia,"6 Aparelhos","28º"));

        final ComodosCasaAdapter adaptador = new ComodosCasaAdapter(getApplicationContext(),Lista);
        listaComodos.setAdapter(adaptador);

        listaComodos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Comodo(position);

                //Toast.makeText(getBaseContext(),"O Comodo "+Comodo(position).toString()+ " Ainda não foi implementado", Toast.LENGTH_LONG).show();

                //CHAMO A TELA DE LIGAR E DESLIGAR LED E PASSO O ID DO COMODO
                Intent intent = new Intent(getBaseContext(), ActivityLigaDesliga.class);

                intent.putExtra("comodo",Comodo(position));
                startActivity(intent);
            }
        });

        listaComodos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), TelaControleDispositivos.class);
                startActivity(intent);
                return false;
            }
        });

    }

    public String Comodo(int posicao){
        String IdComodo =  "Geral";
        switch (posicao){
            case 0:
                IdComodo = "1";
                break;
            case 1:
                IdComodo = "2";
                break;
            case 2:
                IdComodo = "03";
                break;
            case 3:
                IdComodo = "04";
                break;
            case 4:
                IdComodo = "05";
                break;
            case 5:
                IdComodo = "06";
                break;
            case 6:
                IdComodo = "07";
                break;
            case 7:
                IdComodo = "08";
                break;
            case 8:
                IdComodo = "09";
                break;
            case 9:
                IdComodo = "10";
                break;
            case 10:
                IdComodo = "11";
                break;
            case 11:
                IdComodo = "12";
                break;
        }
        return IdComodo;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
