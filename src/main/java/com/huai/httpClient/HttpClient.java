package com.huai.httpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by liangyh on 2/11/2017.
 */
public class HttpClient {

    public String downloadWebData(String url)throws IOException{
        return downloadWebData(url, "UTF-8");
    }

    public String downloadWebData(String url, String charset) throws IOException {
        URL hh= new URL(url);
        URLConnection connection = hh.openConnection();
        connection.setConnectTimeout(15000);
        connection.setReadTimeout(15000);
        String redirect = connection.getHeaderField("Location");
        if (redirect != null){
            connection = new URL(redirect).openConnection();
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));
        StringBuilder builder = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            builder.append(inputLine).append("\n");
        }
        return builder.toString();
    }

}
