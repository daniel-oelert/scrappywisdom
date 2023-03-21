package com.accenture.Scrappy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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


    public void post() {

        ScrappyMastodonClient client = new ScrappyMastodonClient();
        WisdomBaseClient baseClient = new WisdomBaseClient();
        client.mastodonClientInit(token);
        var s = new Scraper();
        String content = null;
        try {
            content = s.getQuote();
            long id =client.postWisdom(content,client.getClient());
            baseClient.postToWisdomBase(connection,content,id);
        } catch (Exception e) {
            System.out.println("Mastodon Error");
        }
    }
    public void stats() {
        ScrappyMastodonClient client = new ScrappyMastodonClient();
        WisdomBaseClient baseClient = new WisdomBaseClient();
        List<MastodonPost> entries = baseClient.getStats(connection);
        for (MastodonPost s: entries){
            System.out.println(s, client.getFavourites(s));
        }
    }
}
