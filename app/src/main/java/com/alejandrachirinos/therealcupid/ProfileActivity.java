package com.alejandrachirinos.therealcupid;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.nostra13.universalimageloader.core.ImageLoader;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.provider.MediaStore;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View.OnClickListener;

import app.horses.camera.CallbackManager;
import app.horses.camera.CameraManager;
import app.horses.camera.view.CallbackView;


public class ProfileActivity extends AppCompatActivity implements CallbackView {
    public static String LOG = LoginActivity.class.getName();
    private static final String TAG = MainActivity.class.getSimpleName();

    private CallbackManager callbackManager = new CallbackManager();
    private AppCompatImageButton buttonCamara;
    private AppCompatImageButton buttonChat;
    private ImageView image;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initViews();
        addEvents();
    }

    private void initViews() {
        buttonCamara = findViewById(R.id.camara);
        image = findViewById(R.id.imageProfile);
    }


    private void addEvents() {
        buttonCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCamara();
            }
        });

    }

    private void abrirCamara() {
        CameraManager.openCamera(this);
        callbackManager.setCallback(this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void successCamera(String path) {
        Log.e(TAG, "successCamera: " + path);

        path = "file:///" + path;

        ImageLoader.getInstance().displayImage(path, image);
    }

    @Override
    public void errorCamera() {
        Log.e(TAG, "errorCamera");

    }

    @Override
    public void cancelCamera() {
        Log.e(TAG, "cancelCamera");

    }
}
