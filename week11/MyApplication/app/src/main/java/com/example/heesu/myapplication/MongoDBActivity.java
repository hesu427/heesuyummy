package com.example.heesu.myapplication;

/**
 * Created by heesu on 2017-12-01.
 */

import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.Set;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class MongoDBActivity extends AppCompatActivity {
    public static void main(String args[]){
        String MongoDB_IP = "ec2-54-250-245-186.ap-northeast-1.compute.amazonaws.com";
        int MongoDB_PORT = 27017;
        String DB_NAME = "yummy";

        //Connect to MongoDB
        MongoClient  mongoClient = new MongoClient(new ServerAddress(MongoDB_IP, MongoDB_PORT));

        //View Database List
        List<String> databases = mongoClient.getDatabaseNames();

        System.out.println("=====Database List===== ");
        int num =1 ;
        for (String dbName : databases) {
            System.out.println( num  + ". " + dbName);
            num++;
        }

        System.out.println();

        //Connect Database and Show Collection List in Database
        DB db = mongoClient.getDB(DB_NAME);
        Set<String> collections = db.getCollectionNames();

        System.out.println("Database : " + DB_NAME);
        for (String colName : collections) {
            System.out.println(" + Collection: " + colName);
        }
    }
}