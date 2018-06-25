package com.test.others;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class Demo05 {
//    private static final String API_KEY = "AIzaSyDanv-o8l3PzvEyHzx09U6Yxnlu7DyF2gM";
//    private static final String API_KEY = "AIzaSyASOOf0X4I4dKSLTImW5R5fnjdvCGgqHKM";
//    private static final String API_KEY = "AIzaSyDu39oCRDsJZBN2H0AMwa0TiyJg3WhtBV0";
    private static final String API_KEY = "AIzaSyA8Dm7sp9xdnhB0-7Kb6pSYwy_TWHtJm3A";

    OkHttpClient client = new OkHttpClient();

    public String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }


    public static void main(String[] args) throws IOException {
        Demo05 request = new Demo05();
//        String url_request = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=Bobrek, PL&destinations=彭巴,莫桑比克&language=zh-CN&key=" + API_KEY;
        String url_request = "https://maps.google.com/maps/api/geocode/json?address=Jamaica, Steer Town&language=zh-CN&sensor=false&key=" + API_KEY;
//        String url_request = "https://maps.google.com/maps/api/geocode/json?latlng=53.7229,14.2885&language=zh-CN&sensor=false&key=" + API_KEY;

        String response = request.run(url_request);
        System.out.println(response);
    }
}
