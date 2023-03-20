package com.accenture.Scrappy;

import social.bigbone.MastodonClient;
import social.bigbone.*;
import social.bigbone.api.*;
import social.bigbone.api.entity.Status;
import social.bigbone.api.entity.Token;


import social.bigbone.api.exception.BigBoneRequestException;

import java.util.Scanner;


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

    public void postWisdom(String postmessage) throws BigBoneRequestException {
        System.out.println("Enter your Access Token:");
        Scanner s = new Scanner(System.in);
        String accessToken = s.nextLine();
        var instanceHostname = "mastodon.social";
        MastodonClient client = new MastodonClient.Builder(instanceHostname).accessToken(accessToken).build();
        MastodonRequest<Status> request = client.statuses()
                .postStatus(postmessage, Status.Visibility.Unlisted);
        Status status = request.execute();


    }
}
