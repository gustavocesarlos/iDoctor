package com.google.firebase.quickstart.auth;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by eduardonoronha on 14/12/2017.
 */

public class Usuario extends Default{
    private int id;
    private String nome;
    private String email;
    private String senha;

    public Usuario(){
        super();
        this.id = -1;
        this.email = "";
        this.nome = "";
        this.senha = "";
    }

    public ArrayList<Usuario> getLista(){
        DB db = new DB();
        ArrayList<Usuario> lista = new ArrayList<>();
        try{
            ResultSet resultSet = db.select("SELECT * FROM usuario");
            if(resultSet != null){
                while (resultSet.next()){
                    Usuario obj = new Usuario();
                    obj.setId(resultSet.getInt("id"));
                    obj.setEmail(resultSet.getString("email"));
                    obj.setNome(resultSet.getString("nome"));
                    obj.setSenha(resultSet.getString("senha"));
                    lista.add(obj);
                    obj = null;
                }

            }else {

            }
        }catch (Exception e){
            this.mensagem = e.getMessage();
            this.status = false;
        }
        return lista;
    }

    public void salvar(){
        String comando = "";
        if(this.getId() == -1){
            comando = String.format("INSERT INTO usuario (nome, email, senha) VALUES ('%s', '%s', '%s');",
                    this.getNome(), this.getEmail(), this.getSenha());
        }
        else {
            comando = String.format("UPDATE usuario SET nome = '%s', email = '%s', senha = '%s' WHERE id = %d;",
                    this.getNome(), this.getEmail(), this.getSenha(), this.getId());
        }
        DB db = new DB();
        db.execute(comando);
        this.mensagem = db.mensagem;
        this.status = db.status;
    }

    public void apagar(){
        String comando = String.format("DELETE FROM usuario WHERE id = %d;", this.getId());
        DB db = new DB();
        db.execute(comando);
        this.mensagem = db.mensagem;
        this.status = db.status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
