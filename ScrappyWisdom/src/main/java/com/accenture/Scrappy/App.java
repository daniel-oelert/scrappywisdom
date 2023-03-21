package com.accenture.Scrappy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class App {

    private String token = null;
    private Connection connection = null;

    public String getToken() {
        return token;
    }

    public App(String accessToken) {
        token = accessToken;
        Connector connector = new Connector();
        try {
            connection = connector.getConnection();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }


    public void run() {

        ScrappyMastodonClient client = new ScrappyMastodonClient();
        WisdomBaseClient baseClient = new WisdomBaseClient();
        client.mastodonClientInit(token);
        var s = new Scraper();
        String content = null;
        try {
            content = s.getQuote();
            client.postWisdom(content,client.getClient());
            baseClient.postToWisdomBase(connection,content);
        } catch (Exception e) {
            System.out.println("Mastodon Error");
        }
    }
}
