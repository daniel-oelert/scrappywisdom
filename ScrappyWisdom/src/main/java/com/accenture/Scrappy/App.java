package com.accenture.Scrappy;

public class App {

    private String token = null;

    public String getToken() {
        return token;
    }

    public App(String accessToken) {
        token = accessToken;
    }


    public void run() {
        ScrappyMastodonClient client = new ScrappyMastodonClient();
        client.mastodonClientInit(token);
        var s = new Scraper();
        try {
            client.postWisdom(s.getQuote(), client.getClient());
        } catch (Exception e) {
            System.out.println("Mastodon Error");
        }
    }
}
