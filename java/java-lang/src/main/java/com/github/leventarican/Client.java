package com.github.leventarican;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5050)){
            Scanner response = new Scanner(socket.getInputStream(), StandardCharsets.UTF_8.name());
            
            File file = new File("java.file");
            System.out.println(file);
            FileInputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = socket.getOutputStream();
            byte[] bytes = new byte[inputStream.available()];
            outputStream.write(inputStream.read(bytes));

            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8.name() ), true);
            out.println("2");
            out.println("100");



            System.out.println(response.nextLine());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
