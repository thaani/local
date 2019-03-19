package com.example.machine;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class display extends AppCompatActivity {
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        APIservice service = APIclient.getClient().create(APIservice.class);
       AssetManager am =getApplicationContext().getAssets();

        Typeface typeface = Typeface.createFromAsset(am,
              String.format(Locale.US, "fonts/%s", "SIXTY.TTF"));




        Call<Example> userCall = service.userDisplay();
        userCall.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.i("res",new Gson().toJson(response.body()));
                Example ex=response.body();
                List<Table> tab= ex.getTable();
                //for (int i=0;i<tab.size();i++)
               // {
                  //  String a=tab.get(i).getName();
                    //Table t=new Table();
                    //t.setName(a);
                //}



                ContactAdapter adapter = new ContactAdapter(getApplicationContext(),tab);

                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });



    }


}
