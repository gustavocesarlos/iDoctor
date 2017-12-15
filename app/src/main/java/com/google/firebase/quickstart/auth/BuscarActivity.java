package com.google.firebase.quickstart.auth;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by bruno on 14/12/2017.
 */

public class BuscarActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscarmed);
    }

}

    public void buscar(View view) {
        EditText nome = (EditText) findViewById(R.id.nomebuscar);
        String medico = nome.getText().toString();

        // Buscar no banco e retornar o que achou

    }