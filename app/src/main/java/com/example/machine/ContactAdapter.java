package com.example.machine;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class ContactAdapter extends  RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private Context mCtx;

    //we are storing all the products in a list
    private List<Table> tab;

    public ContactAdapter(Context mCtx, List<Table> tab) {
        this.mCtx = mCtx;
        this.tab = tab;
    }


//TextView name,phoneno,emailid,college,sorce,course,status,reg,comment;

    @NonNull
    @Override
    public ContactAdapter.ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).
      inflate(R.layout.recycleview_layout,parent, false);
        return new ContactViewHolder(view);
       // LayoutInflater inflater = LayoutInflater.from(mCtx);
      //  View view = inflater.inflate(R.layout.layout_recycleview, null);
      //  return new ContactViewHolder(view);
    }


    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Table tabb = tab.get(position);
      // Table t=examples.get(position)
        holder.name.setText(tabb.getName());
        holder.phoneno.setText(tabb.getPhoneno());
        holder.emailid.setText(tabb.getEmailid());
        holder.college.setText(tabb.getCollege());
        holder.sorce.setText(tabb.getSource());
        Log.i("test",tabb.getCollege());
        holder.course.setText(tabb.getCourse());
        holder.status.setText(tabb.getStatus());
        holder.reg.setText(tabb.getRegDate());
        holder.comment.setText(tabb.getComment());



    }

    @Override
    public int getItemCount() {
         return tab.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView name, phoneno, emailid, college, sorce, course, status, reg, comment;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.rname);
            phoneno = itemView.findViewById(R.id.rphone);
            emailid = itemView.findViewById(R.id.remail);
            college = itemView.findViewById(R.id.rcollege);
            sorce = itemView.findViewById(R.id.rsource);
            course = itemView.findViewById(R.id.rcourse);
            college = itemView.findViewById(R.id.rcollege);

            status = itemView.findViewById(R.id.rstatus);
            reg = itemView.findViewById(R.id.rreg);
            comment = itemView.findViewById(R.id.rcomment);
            AssetManager am =mCtx.getAssets();
            Typeface typeface = Typeface.createFromAsset(am,
                    String.format(Locale.US, "fonts/%s", "SIXTY.TTF"));
            name.setTypeface(typeface);

        }
    }}
    //   name = itemView.findViewById(R.id.name);
           // phoneno=itemView.findViewById(R.id.phoneno);
            //emailid=itemView.findViewById(R.id.email);
            //college = itemView.findViewById(R.id.college);
            //sorce=itemView.findViewById(R.id.source);
            //course=itemView.findViewById(R.id.course);
            //college = itemView.findViewById(R.id.college);

            //status=itemView.findViewById(R.id.status);
           // reg=itemView.findViewById(R.id.regdate);
            //comment=itemView.findViewById(R.id.comment);





