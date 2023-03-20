package com.accenture.Scrappy;

import social.bigbone.api.exception.BigBoneRequestException;

public class Main {



    public static void main(String[] args) throws BigBoneRequestException {
        var app = new App();
        System.out.println(app.token);
        app.run();

    }
}