package com.github.leventarican;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

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
        InputStream in = client.getInputStream();
        OutputStream outFile = new FileOutputStream(new File("server.txt"));
        byte[] bytes = new byte[in.available()];
        int count;
        while ((count = in.read(bytes)) > 0) {
            outFile.write(bytes, 0, count);
        }
        in.close();
        outFile.close();
    }
}
