package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramSocketServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(4000);
        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        datagramSocket.receive(datagramPacket);
        // 打印數組出來，方便檢驗結果是否準確
        System.out.println(new String(buf, 0, datagramPacket.getLength()));
    }
}
