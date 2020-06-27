package com.alejandrachirinos.therealcupid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;

import com.alejandrachirinos.therealcupid.HolderMensaje;
import com.alejandrachirinos.therealcupid.Message;
import com.alejandrachirinos.therealcupid.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class MessageAdapter extends RecyclerView.Adapter<HolderMensaje> {

    private List<Message> listMessage = new ArrayList<>();
    private Context c;

    public MessageAdapter(Context c) {
        this.c = c;
    }

    public void addMessage(Message m){
        listMessage.add(m);
        notifyItemInserted(listMessage.size());
    }

    @NonNull
    @Override
    public HolderMensaje onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.card_view_layout,parent,false);
        return new HolderMensaje(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderMensaje holder, int position) {
        holder.getNombre().setText(listMessage.get(position).getName());
        holder.getMessage().setText(listMessage.get(position).getMensaje());
        holder.getTime().setText(listMessage.get(position).getHora());

    }

    @Override
    public int getItemCount() {
        return listMessage.size();
    }

}
