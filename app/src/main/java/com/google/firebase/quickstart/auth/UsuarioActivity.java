package com.google.firebase.quickstart.auth;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by bruno on 14/12/2017.
 */

public class UsuarioActivity extends Activity{

    private TextView nometv, emailtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        nometv = (TextView)findViewById(R.id.nome);
        emailtv = (TextView)findViewById(R.id.email);
        registermessage();
    }
}

    public void registermessage() {
        nometv.setText("Nome Lido");
        emailtv.setText("Email Lido");
    }