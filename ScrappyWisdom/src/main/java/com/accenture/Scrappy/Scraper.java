package com.accenture.Scrappy;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;

import java.net.HttpURLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scraper {

    public static void main(String[] args) {
        new Scraper().scrape();
    }

    public String scrape() {
        final String httpsUrl = "http://www.wisdomofchopra.com/iframe.php#";
        String output = "";
        try {
            final URL url = new URL(httpsUrl);
            final HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // System.out.println("****** Content of the URL ********");
            final BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String input;


            while ((input = br.readLine()) != null){
                // System.out.println(input);
                output = output + input;
            }
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }
    private String extractTitle(String content) {
        final Pattern titleRegExp = Pattern.compile("<td id=\"quote\"><header><h2>&quot;(.*?)&quot;&nbsp;&nbsp;</h2></header></td>", Pattern.DOTALL);
        final Matcher matcher = titleRegExp.matcher(content);
        matcher.find();
        return matcher.group(1);
    }

    public String getQuote(){
        var page = scrape();
        var quote = extractTitle(page);
        System.out.println(quote);
        return quote;
    }
}
