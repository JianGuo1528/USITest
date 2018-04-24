package com.test.others;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Demo04 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=Font-Romeu-Odeillo-Via&destinations=Font-Romeu,Font-Romeu-Odeillo-Via,France");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        String line, outputString = "";
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        while ((line = reader.readLine()) != null) {
            outputString += line;
        }
        System.out.println(outputString);
    }
}
