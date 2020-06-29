package com.alejandrachirinos.therealcupid;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
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
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class ChatActivity extends AppCompatActivity {

    private ImageView fotoPerfil;
    private TextView name;
    private RecyclerView rvMensaje;
    private EditText txtMensajes;
    private ImageButton btnEnviar;
    private List<Message> listMessages;
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
        btnEnviar = (ImageButton)findViewById(R.id.btnEnviar);

        listMessages = new ArrayList<>();


        adapter = new MessageAdapter(this);
        LinearLayoutManager l = new LinearLayoutManager(this);
        rvMensaje.setLayoutManager(l);
        rvMensaje.setAdapter(adapter);
        rvMensaje.setHasFixedSize(true);

        FirebaseFirestore.getInstance().collection("Chat").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                for (DocumentChange mDocumentChange : queryDocumentSnapshots.getDocumentChanges()){
                    if (mDocumentChange.getType() == DocumentChange.Type.ADDED) {
                        listMessages.add(mDocumentChange.getDocument().toObject(Message.class));
                        adapter.notifyDataSetChanged();
                        rvMensaje.smoothScrollToPosition(listMessages.size());

                    }
                }
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
                FirebaseFirestore.getInstance().collection("Chat").add(mMensajeVO);
                txtMensajes.setText("");
                name.setText("");
                adapter.addMessage( new Message(txtMensajes.getText().toString(), name.getText().toString(),"", "1", "00:00"));
            }
        });
    }
}
