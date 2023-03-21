package com.accenture.Scrappy;

import social.bigbone.MastodonClient;
import social.bigbone.*;
import social.bigbone.api.*;
import social.bigbone.api.entity.Status;
import social.bigbone.api.entity.Token;


import social.bigbone.api.exception.BigBoneRequestException;

import java.util.Scanner;


public class ScrappyMastodonClient {

    private MastodonClient client;



    public void mastodonClientInit(String accessToken) {
        var instanceHostname = "mastodon.social";
        client = new MastodonClient.Builder(instanceHostname).accessToken(accessToken).build();
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

    public MastodonClient getClient(){
        return this.client;
    }

    public void postWisdom(String postmessage, MastodonClient client) throws BigBoneRequestException {
        MastodonRequest<Status> request = client.statuses()
                .postStatus(postmessage, Status.Visibility.Unlisted);
        Status status = request.execute();
    }

}
