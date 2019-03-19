package com.example.machine;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextInputEditText name,phoneno,emailid,college,source,course,status,reg_date,comment;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(TextInputEditText) findViewById(R.id.editname);
        phoneno=(TextInputEditText) findViewById(R.id.editphone);
        emailid=(TextInputEditText)findViewById(R.id.editemail);
        college=(TextInputEditText)findViewById(R.id.editcollege);
        source=(TextInputEditText)findViewById(R.id.editsource);
        course=(TextInputEditText)findViewById(R.id.editcourse);
        status=(TextInputEditText)findViewById(R.id.editstatus);
        reg_date=(TextInputEditText)findViewById(R.id.editregdate);
        comment=(TextInputEditText)findViewById(R.id.editcomment);
       submit=(Button)findViewById(R.id.submit);
       submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String  lname= name.getText().toString();
               String lphone = phoneno.getText().toString();
               String  lemail= emailid.getText().toString();
               String  lcollege= college.getText().toString();
               String  lsource= source.getText().toString();
               String  lcourse= course.getText().toString();
               String  lstatus= status.getText().toString();
               String  lreg= reg_date.getText().toString();
               String  lcomment= comment.getText().toString();
               Integer lid=2;
               APIservice service = APIclient.getClient().create(APIservice.class);

               final Call<Example> userCall = service.userSubmit(lid,lname,lphone,lemail,lcollege,lsource,lcourse,lstatus,lreg,lcomment);
              userCall.enqueue(new Callback<Example>() {
                  @Override
                  public void onResponse(Call<Example> call, Response<Example> response) {

                      Log.i("onResponse", "" + response.body());
                    //  Example exx=response.body();
//List<Table> tb=exx.getTable();
                      // Log.i("res",new Gson().toJson(response.body()));

                      //Example exx=response.body();

                      //List<Table> tab= ex.getTable();

                      Toast.makeText(MainActivity.this, "details successfully submited", Toast.LENGTH_SHORT).show();


                  }

                  @Override
                  public void onFailure(Call<Example> call, Throwable t) {
                      Toast.makeText(MainActivity.this, "submission failed", Toast.LENGTH_SHORT).show();

                  }
              });


           }
       });




    }
}
