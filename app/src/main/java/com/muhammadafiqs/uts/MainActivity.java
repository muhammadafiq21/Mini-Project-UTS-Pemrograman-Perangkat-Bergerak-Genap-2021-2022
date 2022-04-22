package com.muhammadafiqs.uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvPesan;
    private ArrayList<Pesan> list = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPesan = findViewById(R.id.rv_pesan);
        rvPesan.setHasFixedSize(true);

        list.addAll(DetailPesan.getListData());


    }
    private void showRecyclerList(){
        rvPesan.setLayoutManager(new LinearLayoutManager(this));
        ListPesanAdapter listPesanAdapter = new ListPesanAdapter(list);
        rvPesan.setAdapter(listPesanAdapter);
    }
}