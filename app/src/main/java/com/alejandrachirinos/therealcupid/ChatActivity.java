package com.alejandrachirinos.therealcupid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alejandrachirinos.therealcupid.adapter.MessageAdapter;

public class ChatActivity extends AppCompatActivity {

    private ImageView fotoPerfil;
    private TextView name;
    private RecyclerView rvMensaje;
    private EditText txtMensajes;
    private Button btnEnviar;

    private MessageAdapter adapter;

   // private FireBaseDataBase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        fotoPerfil= (ImageView)findViewById(R.id.photoProfile);
        name = (TextView)findViewById(R.id.nameChat);
        rvMensaje = (RecyclerView)findViewById(R.id.rvMensajes);
        txtMensajes = (EditText)findViewById(R.id.txtMensaje);
        btnEnviar = (Button)findViewById(R.id.btnEnviar);

        adapter = new MessageAdapter(this);
        LinearLayoutManager l = new LinearLayoutManager(this);
        rvMensaje.setLayoutManager(l);
        rvMensaje.setAdapter(adapter);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addMessage( new Message(txtMensajes.getText().toString(), name.getText().toString(),"", "1", "00:00"));
            }
        });
    }
}
