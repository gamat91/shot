package com.example.l01571.shot.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.l01571.shot.DAO.EstabelecimentoDAO;
import com.example.l01571.shot.R;
import com.example.l01571.shot.adapter.ListaAdapter;
import com.example.l01571.shot.modelos.Estabelecimento;

public class ListaActivity extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lista = findViewById(R.id.lista);
        EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
        ListaAdapter adapter = new ListaAdapter(estabelecimentoDAO.lista(), this);
        lista.setAdapter(adapter);



        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Estabelecimento estabelecimento = (Estabelecimento)lista.getItemAtPosition(position);
                Intent intent = new Intent(ListaActivity.this, EstabelecimentoActivity.class);
                intent.putExtra("estabelecimento", estabelecimento);
                startActivity(intent);

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lista, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_gps:
                Toast.makeText(this, "Deu certo", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ListaActivity.this, GPSActivity.class);
                startActivity(intent);
                break;

        }


        return super.onOptionsItemSelected(item);
    }
}
