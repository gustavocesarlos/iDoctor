package com.google.firebase.quickstart.auth;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignUpActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void registrar(View view){
        EditText nome = (EditText) findViewById(R.id.nome);
        EditText email = (EditText) findViewById(R.id.email);
        EditText senha = (EditText) findViewById(R.id.password);
        EditText confirmaSenha = (EditText)findViewById(R.id.confirmpassword);

        if(senha.getText().toString().equals(confirmaSenha.getText().toString())){
            AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
            Usuario usuario = new Usuario();
            usuario.setSenha(senha.getText().toString());
            usuario.setNome(nome.getText().toString());
            usuario.setEmail(email.getText().toString());
            usuario.salvar();
            if(!usuario.isStatus()){
                dialogo.setTitle("Cadastro Concluído");
                dialogo.setPositiveButton("OK", null);
                dialogo.show();
                finish();
            }
            else {

            }
        }else{
            AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
            dialogo.setTitle("Senha incorreta");
            dialogo.setMessage("Digite uma senha válida");
            dialogo.setPositiveButton("OK", null);
            dialogo.show();
        }
    }
}

