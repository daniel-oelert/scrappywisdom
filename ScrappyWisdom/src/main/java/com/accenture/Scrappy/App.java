package com.accenture.Scrappy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.util.Scanner;

public class App {

    private String token = null;

    public String getToken() {
        return token;
    }

    public App(String accessToken) {
        // Try to open keystore file, if not succeeds create new one
        token = accessToken;
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
