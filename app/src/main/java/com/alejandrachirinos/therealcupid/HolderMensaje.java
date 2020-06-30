package com.alejandrachirinos.therealcupid;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alejandrachirinos.therealcupid.R;

import java.util.List;


//HolderMensaje

public class HolderMensaje extends RecyclerView.ViewHolder {

    private TextView nombre;
    private  TextView message;
    private TextView time;
    private ImageView photoProfile;

    public HolderMensaje(@NonNull View itemView) {
        super(itemView);
        nombre = (TextView)itemView.findViewById(R.id.namecardview);
        message = (TextView)itemView.findViewById(R.id.messagecardview);
        time = (TextView)itemView.findViewById(R.id.timecardview);
        photoProfile = (ImageView)itemView.findViewById(R.id.photoperfilcardview);
    }

    public TextView getNombre() {
        return nombre;
    }

    public void setNombre(TextView nombre) {
        this.nombre = nombre;
    }

    public TextView getMessage() {
        return message;
    }

    public void setMessage(TextView message) {
        this.message = message;
    }

    public TextView getTime() {
        return time;
    }

    public void setTime(TextView time) {
        this.time = time;
    }

    public ImageView getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile(ImageView photoProfile) {
        this.photoProfile = photoProfile;
    }

}