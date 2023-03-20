package com.accenture.Scrappy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.util.Scanner;

public class App {

    String token = null;

    public App() {
        // Try to open keystore file, if not succeeds create new one
        initToken("SCRAPPY_TOKEN");
    }
    private void initToken(String envVarName) {
        token = System.getenv(envVarName);
    }


    public void run() {
        ScrappyMastodonClient client = new ScrappyMastodonClient();
        var s = new Scraper();
        try {
            client.postWisdom(s.getQuote(),client.getClient());
        } catch (Exception e) {
            System.out.println("Mastodon Error");
        }
    }
}
