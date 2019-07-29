package com.github.leventarican;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * javac UDPServer.java && java -cp ..\..\..\ com.github.leventarican.UDPServer
 */
public class UDPServer {
  public static void main( String[] args ) throws IOException {
    DatagramSocket socket = new DatagramSocket( 5151 );

    while ( true ) {
      // wait for request
      DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
      socket.receive( packet );

      // read payload
      InetAddress address = packet.getAddress();
      int port = packet.getPort();
      int len = packet.getLength();
      byte[] data = packet.getData();

      System.out.printf("request from %s port %d ltn %d:%n%s%n",
              address, port, len, new String( data, 0, len ) );
    }
  }
}