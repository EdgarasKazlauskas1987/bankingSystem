package com.bank.bankingSystem.Utilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Notifier {

    private static boolean isSuccessfulResponse(String responseCode) {
        Pattern pattern = Pattern.compile("^2\\d{2}$");
        Matcher matcher = pattern.matcher(responseCode);

        return matcher.matches();
    }

    public static boolean notifyExternalService(String urlAddress) throws IOException {

        URL url = new URL(urlAddress);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        String responseCode = String.valueOf(connection.getResponseCode());

        connection.disconnect();

        return isSuccessfulResponse(responseCode);
    }
}
