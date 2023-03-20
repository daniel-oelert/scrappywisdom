package com.accenture.Scrappy;

import social.bigbone.api.exception.BigBoneRequestException;

public class Main {
    public static void main(String[] args) throws BigBoneRequestException {
        ScrappyMastodonClient client = new ScrappyMastodonClient();
        var s = new Scraper();
        try{
            client.postWisdom(s.getQuote());
        }catch(Exception e){
            System.out.println("Mastodon Error");
        }

    }
}