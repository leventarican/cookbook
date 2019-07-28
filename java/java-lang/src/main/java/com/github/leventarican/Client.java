package com.github.leventarican;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5050)){
            File file = new File("java.file");
            InputStream in = new FileInputStream(file);
            OutputStream out = socket.getOutputStream();
            byte[] bytes = new byte[in.available()];

            int count;
            while ((count = in.read(bytes)) > 0) {
                out.write(bytes, 0, count);
            }
            out.close();
            in.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
