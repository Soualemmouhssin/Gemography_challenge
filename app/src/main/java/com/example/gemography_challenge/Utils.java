package com.example.gemography_challenge;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Utils {
    private static String TAG = "myDebug";
    // Given a URL, establishes an HttpUrlConnection and retrieves
    // the web page content as a InputStream, which it returns as
    // a string.
    public static String Get_url(String id) throws IOException {
        InputStream is = null;
        try {
            URL url = new URL( id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000); // time in milliseconds
            conn.setConnectTimeout(15000); // connection time in milliseconds
            conn.setRequestMethod("GET"); // request method GET OR POST
            conn.setDoInput(true);
            // Starts the query
            conn.connect(); // calling the web address
            int response = conn.getResponseCode();
            is = conn.getInputStream();

            // Converting the received stream into a string
            String inputAsStr = readInputStream(is);
            Log.d(TAG,inputAsStr);
            return inputAsStr;
        }
        // Makes sure that the InputStream is closed after the app is
        catch (Exception e) { e.printStackTrace();
            Log.d(TAG, "exception " + e.toString());
            return null ; }
    }

    // Reads an InputStream and converts it to a String.
    public static String readInputStream(InputStream stream) throws IOException {
        int n = 0;
        char[] buffer = new char[1024 * 4];
        InputStreamReader reader = new InputStreamReader(stream, "UTF8");
        StringWriter writer = new StringWriter();
        while (-1 != (n = reader.read(buffer)))
            writer.write(buffer, 0, n);
        return writer.toString();
    }
}
