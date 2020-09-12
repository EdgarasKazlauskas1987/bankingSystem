package com.bank.bankingSystem.Utilities;

import io.ipinfo.api.IPInfo;
import io.ipinfo.api.errors.RateLimitedException;
import io.ipinfo.api.model.IPResponse;

import java.net.Inet4Address;
import java.net.UnknownHostException;

public class IPhandler {

    private static String getIPAddress() throws UnknownHostException {
        return Inet4Address.getLocalHost().getHostAddress();
    }

    public static void publishClientsCountry() {
        IPInfo ipInfo = IPInfo.builder().setToken("e5a7c7475a76a5").build();

        try {
            IPResponse response = ipInfo.lookupIP(getIPAddress());

            System.out.println("Clients country is: " + response.getCountryCode());
        } catch (RateLimitedException e) {
            System.out.println("Unable to fetch clients country");
        } catch (UnknownHostException e) {
            System.out.println("Unable to fetch clients IP address");
        }
    }
}
