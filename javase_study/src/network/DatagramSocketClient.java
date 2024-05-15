package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramSocketClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        byte[] bytes = "Hello World".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 4000);
        datagramSocket.send(datagramPacket);
    }
}
