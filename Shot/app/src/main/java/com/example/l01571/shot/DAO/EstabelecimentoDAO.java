package com.example.l01571.shot.DAO;

import com.example.l01571.shot.modelos.Estabelecimento;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EstabelecimentoDAO {

    public List<Estabelecimento> lista(){

        List<Estabelecimento> lista = new ArrayList<Estabelecimento>();

        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setNome("Chemistry Bar");
        estabelecimento.setImagem("chemistry");
        estabelecimento.setEndereco("rua do camacua 397");
        lista.add(estabelecimento);

        Estabelecimento estabelecimento2 = new Estabelecimento();
        estabelecimento2.setNome("Blood Rock Bar");
        estabelecimento2.setEndereco("av silva jardim 1538");
        estabelecimento2.setImagem("blood");
        lista.add(estabelecimento2);

        Estabelecimento estabelecimento3 = new Estabelecimento();
        estabelecimento3.setNome("Verdant");
        estabelecimento3.setEndereco("av silva jardim 1538");
        estabelecimento3.setImagem("verdant");
        lista.add(estabelecimento3);

        Estabelecimento estabelecimento4 = new Estabelecimento();
        estabelecimento4.setNome("Vitto Bar");
        estabelecimento4.setEndereco("av silva jardim 1538");
        estabelecimento4.setImagem("vitto");
        lista.add(estabelecimento4);

        Estabelecimento estabelecimento5 = new Estabelecimento();
        estabelecimento5.setNome("92 Graus");
        estabelecimento5.setEndereco("av silva jardim 1538");
        estabelecimento5.setImagem("graus");
        lista.add(estabelecimento5);




        /*        (Arrays.asList(
           new Estabelecimento("Chemistry Bar", "sao_paulo_sp","rua do camacua 397"),
           new Estabelecimento("Blood Rock Bar", "sao_paulo_sp"),
           new Estabelecimento("Vitto Bar", "sao_paulo_sp"),
           new Estabelecimento("VU Bar", "sao_paulo_sp"),
           new Estabelecimento("92 Graus", "sao_paulo_sp")
        ));
        */


        return lista;

    }



}
