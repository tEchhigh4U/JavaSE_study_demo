package network.demo3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 3000);

        System.out.println("Please enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        SocketUtils.sendMsg(socket, "Hello I am client --- " + name);
//        outputStream.close(); // 關閉，否則服務器如果多次使用is.read的話，就會出現異常Connection reset

        // 客戶端讀取服務端的消息
        System.out.println("Message is receiving from the client sides now.");
        while (true) {
            System.out.println(SocketUtils.receiveMsg(socket));
        }

    }
}
