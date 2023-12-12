package org.linus.firebase_javafx;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class Firebase {
    URL url;
    static String getResponse(InputStream stream) throws IOException {
        String buffer;
        StringBuffer response = new StringBuffer();
        BufferedReader res = new BufferedReader(new InputStreamReader(stream));
        while ((buffer = res.readLine()) != null)
            response.append(buffer);
        return response.toString();
    }

    String getNote() {
        String METHOD = "GET";
        String AUTH_STRING = ""; // Set this as required or comment it out.
        try {
            String response;

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod(METHOD);
            conn.setDoOutput(false);
            conn.setRequestProperty("Authorization", AUTH_STRING);
            System.out.println("Response Code: " + conn.getResponseCode());
            if (conn.getResponseCode() != 200)
                response = getResponse(conn.getErrorStream());
            else
                response = getResponse(conn.getInputStream());
            System.out.println("Response Body: " + response);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            HashMap<String, String> thing = gson.fromJson(response, new TypeToken<HashMap<String, Object>>(){}.getType());

            return thing.get("note");
        }
        catch (IOException e) {e.printStackTrace();}
        return "";
    }

    void setNote(String note) throws IOException {

        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("PUT");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        String jsonInputString = "{\"note\": \"" + note + "\"}";

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
    }

    Firebase(String url) throws MalformedURLException {
        this.url = new URL(url);
    }
}
