package com.github.leventarican;

import java.io.*;
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
        InputStream inputStream = client.getInputStream();
        Scanner in = new Scanner(inputStream, StandardCharsets.UTF_8.name());

        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        OutputStream outStream = new FileOutputStream(new File("server.file"));
        outStream.write(buffer);

        PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream(), StandardCharsets.UTF_8.name()), true);
        out.println("file received");
    }
}
