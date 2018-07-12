package com.example.l01571.shot.acitivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.l01571.shot.DAO.EstabelecimentoDAO;
import com.example.l01571.shot.R;
import com.example.l01571.shot.adapter.ListaAdapter;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        ListView lista = findViewById(R.id.lista);
        EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
        lista.setAdapter(new ListaAdapter(estabelecimentoDAO.lista(), this));


    }
}
