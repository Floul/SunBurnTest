package com.example.android.sunburntest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocationClient;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    List<Site> webSites = new ArrayList<>();
    String userCountryCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webSites.add(new Site("YouTube", "https://www.youtube.com/"));
        webSites.add(new Site("Ukrzaliznytsya", "https://www.uz.gov.ua/", new String[]{"UA"}));
        webSites.add(new Site("Google", "https://google.com/"));

        userCountryCode = UserLocationGetter.getUserLocation(this);
        Toast.makeText(this,userCountryCode,Toast.LENGTH_LONG).show();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerViewAdapter = new RecyclerViewAdapter(webSites,userCountryCode);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
