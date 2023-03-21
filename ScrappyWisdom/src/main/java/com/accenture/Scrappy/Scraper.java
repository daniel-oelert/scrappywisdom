package com.accenture.Scrappy;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;

import java.net.HttpURLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scraper {
    private static final String SCRAPE_URL = "http://www.wisdomofchopra.com/iframe.php#";
    public static final String REGEX_QUOTEMATCH = "<td id=\"quote\"><header><h2>&quot;(.*?)&quot;&nbsp;&nbsp;</h2></header></td>";

    public static void main(String[] args) {
        new Scraper().scrape();
    }

    public String scrape() {

        String output = "";
        BufferedReader br = null;
        try {
            final URL url = new URL(SCRAPE_URL);
            final HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // System.out.println("****** Content of the URL ********");
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String input;

            while ((input = br.readLine()) != null) {
                // System.out.println(input);
                output = output + input;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return output;
    }

    private String extractTitle(String content) {
        final Pattern titleRegExp = Pattern.compile(REGEX_QUOTEMATCH, Pattern.DOTALL);
        final Matcher matcher = titleRegExp.matcher(content);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "";
        }
    }

    public String getQuote() {
        var page = scrape();
        var quote = extractTitle(page);
        System.out.println(quote);
        return quote;
    }
}
