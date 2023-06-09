package com.jhs.mystudyapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PHPviewholder extends RecyclerView.ViewHolder{
    public TextView id,name,hp;

    public PHPviewholder(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.id);
        name = itemView.findViewById(R.id.name);
        hp = itemView.findViewById(R.id.hp);
    }
}
