package com.example.l01571.shot.fragments;


import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.l01571.shot.DAO.EstabelecimentoDAO;
import com.example.l01571.shot.modelos.Estabelecimento;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FragmentGPS extends SupportMapFragment implements OnMapReadyCallback {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        CameraUpdate camera = CameraUpdateFactory.newLatLngZoom(buscaCoordenada("Avenida silva jardim 1538"), 17);
        googleMap.moveCamera(camera);

        EstabelecimentoDAO dao = new EstabelecimentoDAO();
        for(Estabelecimento estabelecimento:dao.lista()){
            LatLng coordenada = buscaCoordenada(estabelecimento.getEndereco());
            if(coordenada!=null){
                MarkerOptions marker = new MarkerOptions();
                marker.position(coordenada);
                marker.title(estabelecimento.getNome());
                googleMap.addMarker(marker);
            }

        }



    }

    private LatLng buscaCoordenada(String endereco){
        try {
            Geocoder geo = new Geocoder(getContext());
            List<Address> resultados = geo.getFromLocationName(endereco,1);
            if(!resultados.isEmpty()){
                LatLng posicao = new LatLng(resultados.get(0).getLatitude(), resultados.get(0).getLongitude());
                return posicao;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

}
