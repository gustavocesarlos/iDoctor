package com.google.firebase.quickstart.auth;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by eduardonoronha on 14/12/2017.
 */

public class Medico extends Default{
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String especialidade;
    private boolean atendePlano;
    private String endereco;

    public Medico(){
        super();
        this.id = -1;
        this.email = "";
        this.nome = "";
        this.telefone = "";
        this.atendePlano = false;
        this.endereco = "";
        this.especialidade = "";
    }

    public ArrayList<Medico> getLista(){
        DB db = new DB();
        ArrayList<Medico> lista = new ArrayList<>();
        try{
            ResultSet resultSet = db.select("SELECT * FROM medico");
            if(resultSet != null){
                while (resultSet.next()){
                    Medico obj = new Medico();
                    obj.setId(resultSet.getInt("id"));
                    obj.setEmail(resultSet.getString("email"));
                    obj.setNome(resultSet.getString("nome"));
                    obj.setAtendePlano(resultSet.getBoolean("atendePlano"));
                    obj.setEndereco(resultSet.getString("endereco"));
                    obj.setEspecialidade(resultSet.getString("especialidade"));
                    obj.setTelefone(resultSet.getString("telefone"));
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
            comando = String.format("INSERT INTO usuario (email, endereco, telefone, nome, especialidade," +
                            " atendePlano) VALUES ('%s', '%s', '%s', '%s', '%s', '%s');",
                            this.getEmail(), this.getEndereco(), this.getTelefone(),
                            this.getNome(), this.getEspecialidade(), this.isAtendePlano());
        }
        else {
            comando = String.format("UPDATE usuario SET email = '%s', endereco = '%s', telefone = '%s', " +
                            "nome = '%s', especialidade = '%s', atendePlano = '%s' WHERE id = %d;",
                    this.getEmail(), this.getEndereco(), this.getTelefone(),
                    this.getNome(), this.getEspecialidade(), this.isAtendePlano(), this.getId());
        }
        DB db = new DB();
        db.execute(comando);
        this.mensagem = db.mensagem;
        this.status = db.status;
    }

    public void apagar(){
        String comando = String.format("DELETE FROM medico WHERE id = %d;", this.getId());
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public boolean isAtendePlano() {
        return atendePlano;
    }

    public void setAtendePlano(boolean atendePlano) {
        this.atendePlano = atendePlano;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
