package com.example.l01571.shot.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.l01571.shot.R;
import com.example.l01571.shot.modelos.Estabelecimento;

import org.w3c.dom.Text;

import java.util.List;


public class ListaAdapter extends BaseAdapter {

    private final List<Estabelecimento> lista;
    private final Context context;

    public ListaAdapter(List<Estabelecimento> lista, Context context){
        this.lista = lista;
        this.context = context;

    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);
        Estabelecimento estabelecimento = lista.get(position);

        TextView nome = view.findViewById(R.id.lista_item_nome);
        nome.setText(estabelecimento.getNome());

        ImageView imagem = view.findViewById(R.id.item_lista_imagem);
        Resources resources = context.getResources();
        int id = resources.getIdentifier(estabelecimento.getImagem(), "drawable", context.getPackageName());
        imagem.setImageDrawable(resources.getDrawable(id));



        return view;
    }
}
