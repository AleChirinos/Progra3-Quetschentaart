package com.alejandrachirinos.therealcupid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alejandrachirinos.therealcupid.adapter.MessageAdapter;

import java.util.ArrayList;
import java.util.List;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import javax.annotation.Nullable;


public class ChatActivity extends AppCompatActivity {

    private ImageView fotoPerfil;
    private EditText name;
    private RecyclerView rvMensaje;
    private EditText txtMensajes;
    private Button btnEnviar;
    private MessageAdapter adapter;

    private List <Message> ms;
    //cambios

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        fotoPerfil= (ImageView)findViewById(R.id.photoProfile);
        name = (EditText) findViewById(R.id.txtName);
        rvMensaje = (RecyclerView)findViewById(R.id.rvMensajes);
        txtMensajes = (EditText)findViewById(R.id.txtMensaje);
        btnEnviar = (Button)findViewById(R.id.btnEnviar);

        ms = new ArrayList<>();

        adapter = new MessageAdapter(this);
        LinearLayoutManager l = new LinearLayoutManager(this);
        rvMensaje.setLayoutManager(l);
        rvMensaje.setAdapter(adapter);

        FirebaseFirestore.getInstance().collection("Chat").addSnapshotListener(new EventListener<QuerySnapshot>(){
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                for (DocumentChange mDocumentChange : queryDocumentSnapshots.getDocumentChanges()) {
                    //if (mDocumentChange.getType() == DocumentChange.Type.ADDED) {
                        ms.add(mDocumentChange.getDocument().toObject(Message.class));
                   // }
                }
                adapter.notifyDataSetChanged();
                rvMensaje.smoothScrollToPosition(ms.size());
                adapter.setListMessage(ms);
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtMensajes.length() == 0 || name.length() == 0)
                    return;
                Message mMensajeVO = new Message();
                mMensajeVO.setMensaje(txtMensajes.getText().toString());
                mMensajeVO.setName(name.getText().toString());
                //adapter.addMessage( new Message(txtMensajes.getText().toString(), name.getText().toString(),"", "1", ""));
                FirebaseFirestore.getInstance().collection("Chat").add(mMensajeVO);
                txtMensajes.setText("");
            }
        });
    }
}
