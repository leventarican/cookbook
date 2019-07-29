package com.github.leventarican;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

/**
 * javac UDPServer.java && java -cp ..\..\..\ com.github.leventarican.UDPServer
 */
class UDPClient {
  public static void main( String[] args ) throws IOException, InterruptedException {
    InetAddress ia = InetAddress.getByName("localhost");

    while ( true ) {
      String s = new Date().toString();
      byte[] raw = s.getBytes();

      DatagramPacket packet = new DatagramPacket(raw, raw.length, ia, 5151);
      DatagramSocket dSocket = new DatagramSocket();
      dSocket.send( packet );
      System.out.println( "payload sent" );

      Thread.sleep( 1000 );
    }
  }
}