package com.google.firebase.quickstart.auth;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.concurrent.ExecutionException;

/**
 * Created by eduardonoronha on 14/12/2017.
 */

public class DB extends Default implements Runnable{

    private Connection con;
    private String host = "";
    private String db = "android";
    private int port = 2345;
    private String user = "android";
    private String password = "root";
    private String url = "jdbc:postgresql://%s:%d/%s";

    public DB() {
        super();
        this.url = String.format(this.url, this.host, this.port, this.db);

        this.conecta();
        this.disconecta();
    }

    @Override
    public void run() {
        try{
            Class.forName("org.postgresql.Driver");
            this.con = DriverManager.getConnection(this.url, this.user, this.password);

        }
        catch (Exception e){
            this.mensagem = e.getMessage();
            this.status = false;
        }
    }

    private void conecta(){
        Thread thread = new Thread(this);
        thread.start();
        try{
            thread.join();
        }catch (Exception e){
            this.mensagem = e.getMessage();
            this.status = false;
        }
    }

    private void disconecta(){
        if (this.con != null){
            try{
                this.con.close();
            }
            catch (Exception e){

            }
            finally {
                this.con = null;
            }
        }
    }

    public ResultSet select(String query){
        this.conecta();
        ResultSet resultSet = null;
        try{
            resultSet = new ExecuteDB(this.con, query).execute().get();
        }catch (Exception e){
            this.status = false;
            this.mensagem = e.getMessage();
        }
        return resultSet;
    }

    public ResultSet execute(String query){
        this.conecta();
        ResultSet resultSet = null;
        try{
            resultSet = new ExecuteDB(this.con, query).execute().get();
        }catch (Exception e){
            this.status = false;
            this.mensagem = e.getMessage();
        }
        return resultSet;
    }
}
