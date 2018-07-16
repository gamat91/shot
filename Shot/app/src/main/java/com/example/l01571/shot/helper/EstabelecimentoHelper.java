package com.example.l01571.shot.helper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.l01571.shot.R;
import com.example.l01571.shot.acitivities.EstabelecimentoActivity;
import com.example.l01571.shot.modelos.Estabelecimento;

public class EstabelecimentoHelper {

    private final TextView camponome;
    private final EditText campoendereco;
    private final ImageView campoimagem;

    Estabelecimento estabelecimento = new Estabelecimento();

    public EstabelecimentoHelper(EstabelecimentoActivity activity){
        campoendereco = activity.findViewById(R.id.estabelecimento_endereco);
        camponome = activity.findViewById(R.id.estabelecimento_nome);
        campoimagem = activity.findViewById(R.id.estabelecimento_imagem);

    }


    public void setEstabelecimento(Estabelecimento estabelecimento, Context context){
        camponome.setText(estabelecimento.getNome());
        campoendereco.setText(estabelecimento.getEndereco());

        Resources resources = context.getResources();
        int drawableID = resources.getIdentifier(estabelecimento.getImagem(), "drawable", context.getPackageName());
        Drawable drawable = resources.getDrawable(drawableID);
        campoimagem.setImageDrawable(drawable);



        this.estabelecimento = estabelecimento;
    }


}
