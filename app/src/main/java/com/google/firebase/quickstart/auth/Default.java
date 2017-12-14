package com.google.firebase.quickstart.auth;

/**
 * Created by eduardonoronha on 14/12/2017.
 */

public class Default {
    protected String mensagem;
    protected boolean status;

    public Default(){
        this.status = true;
        this.mensagem = "";
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
