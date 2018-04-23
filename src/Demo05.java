import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class Demo05 {
    private static final String API_KEY = "AIzaSyDanv-o8l3PzvEyHzx09U6Yxnlu7DyF2gM";

    OkHttpClient client = new OkHttpClient();

    public String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }


    public static void main(String[] args) throws IOException {
        Demo05 request = new Demo05();
        String url_request = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=Saint-Bertrand-de-Comminges&destinations=Natural Park Alcornocales&key=" + API_KEY;
//        String url_request = "https://maps.google.com/maps/api/geocode/json?address=Robertson - TN&sensor=false&key=" + API_KEY;
//        String url_request = "https://maps.google.com/maps/api/geocode/json?latlng=43.8136641364528,-70.1506438851084&sensor=false&key=" + API_KEY;

        String response = request.run(url_request);
        System.out.println(response);

    }
}
