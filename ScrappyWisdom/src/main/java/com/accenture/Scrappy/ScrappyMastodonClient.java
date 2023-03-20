package com.accenture.Scrappy;

import social.bigbone.MastodonClient;
import social.bigbone.*;
import social.bigbone.api.*;


import social.bigbone.api.exception.BigBoneRequestException;


public class ScrappyMastodonClient {


    public void mastodonClientInit() {
        var instanceHostname = "mastodon.social";
        MastodonClient client = new MastodonClient.Builder(instanceHostname).build();
        try {
            var appRegistration = client.apps().createApp(
                    "ScrappyWisdom",
                    "urn:ietf:wg:oauth:2.0:oob",
                    new Scope(),
                    ""
            ).execute();
        } catch (BigBoneRequestException e) {
            // error handling
        }
    }
}
