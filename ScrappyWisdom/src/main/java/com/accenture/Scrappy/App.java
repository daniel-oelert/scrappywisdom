package com.accenture.Scrappy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class App {

    private final ScrappyMastodonClient mastodonClient;
    private final WisdomBaseClient dbClient;
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        mastodonClient = new ScrappyMastodonClient();
        dbClient = new WisdomBaseClient();
        mastodonClient.mastodonClientInit(token);

    }


    public void post() {


        var s = new Scraper();
        String content = null;
        try {
            content = s.getQuote();
            long id = mastodonClient.postWisdom(content, mastodonClient.getClient());
            dbClient.postToWisdomBase(connection, content, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void stats() {
        List<MastodonPost> entries = dbClient.getStats(connection);
        try {
            for (MastodonPost s : entries) {
                System.out.println(s.content() + " " + mastodonClient.getFavourites(s));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
