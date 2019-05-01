package com.wamiraj.algos.web_crawler;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

    private Queue<String> queue = new LinkedList<>();
    private List<String> discoveredWebsiteLists = new LinkedList<>();

    public void discoverWeb(String root) {
        queue.add(root);
        discoveredWebsiteLists.add(root);

        while(!queue.isEmpty()) {
            String v = queue.remove();
            String rawHtml = readURL(v);
            System.out.println("RAwhtml  -> " + rawHtml);

            String regEx = "http://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(rawHtml);

            while(matcher.find()) {
                String actualUrl = matcher.group();

                if(!discoveredWebsiteLists.contains(actualUrl)) {
                    discoveredWebsiteLists.add(actualUrl);
                    System.out.println("Website found -> " + actualUrl);
                    queue.add(actualUrl);
                }
            }
        }

    }

    private String readURL(String v) {
        String rawHtml = "";
        try {

            URL url = new URL(v);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine = "";

            while((inputLine = in.readLine()) != null) {
                rawHtml += inputLine;
            }
            in.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
        return rawHtml;
    }

    public static void main(String[] args) {
        WebCrawler webCrawler = new WebCrawler();
        webCrawler.discoverWeb("http://www.google.com");
    }
}
