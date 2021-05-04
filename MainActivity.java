package com.genggam.projekfilm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listPo)
    RecyclerView lisMo;
    MoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter = new MoAdapter();
        lisMo.setLayoutManager(new LinearLayoutManager(this));
        lisMo.setAdapter(adapter);
        lisMo.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        RestClient.getService().getMo().enqueue(new Callback<MoResponse>() {
            @Override
            public void onResponse(Call<MoResponse> call, Response<MoResponse> response) {
                adapter.listMo.addAll(response.body().getSearch());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MoResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }
}
