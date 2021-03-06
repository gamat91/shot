package com.example.l01571.shot.helper;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
//import android.location.LocationListener;
import com.google.android.gms.location.LocationListener;

import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class Localizador implements GoogleApiClient.ConnectionCallbacks, LocationListener{

        private final GoogleApiClient client;
        private final GoogleMap mapa;
        private final Context context;
        private Marker m;

    public Localizador(Context context, GoogleMap mapa) {
        client = new GoogleApiClient.Builder(context).addApi(LocationServices.API).addConnectionCallbacks(this).build();

        client.connect();
        this.mapa = mapa;
        this.context = context;
        this.m = null;


    }

    @Override
    public void onLocationChanged(Location location) {

        LatLng posicao = new LatLng(location.getLatitude(), location.getLongitude());
        CameraUpdate camera = CameraUpdateFactory.newLatLngZoom(posicao, 17);
        MarkerOptions marker = new MarkerOptions();
        marker.position(posicao);
        marker.title("Sua localização");
        if(m == null) {
            m = mapa.addMarker(marker);
        }else {
            m.setPosition(posicao);
        }
        mapa.moveCamera(camera);
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {

        final LocationManager manager = (LocationManager) context.getSystemService(context.LOCATION_SERVICE);
        if(!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            mensagemAlertaGps();
        }



        LocationRequest location = new LocationRequest();
        location.setSmallestDisplacement(50);
        location.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        location.setInterval(1000);


        //if(ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(client, location, this);
        //}
        /*FusedLocationProviderClient locationClient = LocationServices.getFusedLocationProviderClient(context);

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationClient.getLastLocation().addOnSuccessListener((Executor) this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) ;
                {


                }
            }
        });
*/
    }

    private void mensagemAlertaGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Você gostaria de habilitar o GPS?").setCancelable(false).setPositiveButton("Sim", new DialogInterface.OnClickListener(){
            public void onClick (final DialogInterface dialog, final int id){
                context.startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }
        }).setNegativeButton("Não", new DialogInterface.OnClickListener(){
            public void onClick(final DialogInterface dialog, final int id){
                dialog.cancel();
            }
        });
        final AlertDialog alerta = builder.create();
        alerta.show();

    }

    @Override
    public void onConnectionSuspended(int i) {

    }
}
