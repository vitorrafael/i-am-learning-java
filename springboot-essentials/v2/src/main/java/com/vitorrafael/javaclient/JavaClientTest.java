package com.vitorrafael.javaclient;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class JavaClientTest {
    public static void main(String[] args) {
        // Example of a pure java connection without SpringBoot
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL("http://localhost:8080/v2/protected/students/18");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Authentication
            String authHeaderValue = "Basic " + encodeUsernamePassword("admin", "admin");
            connection.addRequestProperty("Authorization", authHeaderValue);

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder jsonSB = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonSB.append(line);
            }
            System.out.println(jsonSB.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(reader);
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private static String encodeUsernamePassword(String user, String password) {
        String userPassword = String.format("%s:%s", user, password);
        return new String(Base64.encodeBase64(userPassword.getBytes()));
    }
}
