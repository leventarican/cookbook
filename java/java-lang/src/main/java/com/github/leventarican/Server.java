package com.github.leventarican;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(5050)) {
            while (true) {
                try (Socket client = server.accept()) {
                    responseTo(client);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void responseTo(Socket client) throws IOException {
        Scanner in = new Scanner(client.getInputStream(), StandardCharsets.UTF_8.name());
        String factor1 = in.nextLine();
        String factor2 = in.nextLine();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream(), StandardCharsets.UTF_8.name()), true);
        out.println(new BigInteger(factor1).multiply(new BigInteger(factor2)));
    }
}
