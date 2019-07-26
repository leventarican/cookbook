package com.github.leventarican;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class Network {
    public void exec() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            for (InetAddress address : Collections.list(networkInterface.getInetAddresses())) {
                System.out.println("hostname: " + address.getHostName());
                System.out.println("canonical hostname: " + address.getCanonicalHostName());
                System.out.println("host address: " + address.getHostAddress());
            }
        }
    }
}
