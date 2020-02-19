package app.bruno.minhacasa;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ComodosCasaAdapter extends BaseAdapter {
    private  Context contexto;
    private   ArrayList<ComodosCasa> elementos;

    public ComodosCasaAdapter(Context contexto, ArrayList<ComodosCasa> elementos) {
        this.contexto = contexto;
        this.elementos = elementos;
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public Object getItem(int position) {
        return elementos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return elementos.get(position).getImagem();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.partescasa, parent, false);

        TextView nome = (TextView) rowView.findViewById(R.id.txtNome);
        TextView descricao =(TextView) rowView.findViewById(R.id.txtDescricao);
        TextView temperatura = (TextView) rowView.findViewById(R.id.txtTemperatura);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.imgImagem);

        nome.setText(elementos.get(position).getNome());
        descricao.setText(elementos.get(position).getAparelhos());
        temperatura.setText(elementos.get(position).getTemperetura());
        imagem.setImageResource(elementos.get(position).getImagem());

        return rowView;
    }
}
