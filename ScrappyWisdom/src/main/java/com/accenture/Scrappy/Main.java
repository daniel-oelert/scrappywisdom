package com.accenture.Scrappy;

import social.bigbone.api.exception.BigBoneRequestException;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {



    public static void main(String[] args) throws BigBoneRequestException{
        var app = new App(System.getenv("TOKEN"));
        app.run();

    }
}