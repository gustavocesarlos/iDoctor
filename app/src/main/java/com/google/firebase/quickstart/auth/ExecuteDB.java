package com.google.firebase.quickstart.auth;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by eduardonoronha on 14/12/2017.
 */

public class ExecuteDB extends AsyncTask<String, Void, ResultSet> {
    private Connection connection;
    private String query;

    public ExecuteDB(Connection connection, String query) {
        this.connection = connection;
        this.query = query;
    }

    @Override
    protected ResultSet doInBackground(String... strings) {
        ResultSet resultSet = null;

        try {
            resultSet = connection.prepareStatement(query).executeQuery();
        }catch (Exception e){

        }finally {
            try{
                connection.close();
            }
            catch (Exception e){

            }
        }

        return resultSet;
    }
}
