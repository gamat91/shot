package com.example.l01571.shot.DAO;

import com.example.l01571.shot.modelos.Estabelecimento;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EstabelecimentoDAO {

    public List<Estabelecimento> lista(){

        List<Estabelecimento> lista = new ArrayList<>(Arrays.asList(
           new Estabelecimento("Chemistry Bar", "sao_paulo_sp"),
           new Estabelecimento("Blood Rock Bar", "sao_paulo_sp"),
           new Estabelecimento("Vitto Bar", "sao_paulo_sp"),
           new Estabelecimento("VU Bar", "sao_paulo_sp"),
           new Estabelecimento("92 Graus", "sao_paulo_sp")
        ));

        return lista;

    }



}
