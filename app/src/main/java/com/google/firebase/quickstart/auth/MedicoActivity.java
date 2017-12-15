package com.google.firebase.quickstart.auth;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by bruno on 14/12/2017.
 */

public class MedicoActivity extends Activity{

    private TextView nometv, espectv, phonetv, endtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medico);
        nometv = (TextView)findViewById(R.id.nomeMedico);
        espectv = (TextView)findViewById(R.id.especMedico);
        phonetv = (TextView)findViewById(R.id.phoneMedico);
        endtv = (TextView)findViewById(R.id.endMedico);
        registermessage();
    }
}

    public void registermessage() {
        nometv.setText("Nome Lido");
        espectv.setText("Especialidade Lida");
        phonetv.setText("Telefone Lido");
        endtv.setText("Endereco Lido");
    }