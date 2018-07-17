package com.example.l01571.shot.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.l01571.shot.R;
import com.example.l01571.shot.helper.EstabelecimentoHelper;
import com.example.l01571.shot.modelos.Estabelecimento;

public class EstabelecimentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estabelecimento);

        EstabelecimentoHelper helper = new EstabelecimentoHelper(this);

        Intent intent = getIntent();
        Estabelecimento estabelecimento = (Estabelecimento) intent.getSerializableExtra("estabelecimento");
        if(estabelecimento != null){
            helper.setEstabelecimento(estabelecimento, this);
        }



    }

}
