package network.demo2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 3000);
        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your name:");
        String name = scanner.nextLine();
        while (true) {
            outputStream.write((name + ": " + scanner.nextLine()).getBytes());
        }

//        outputStream.write("Hello I am client1. 你好，我是客戶端1!".getBytes());
//        outputStream.write("Hello I am client2. 你好，我是客戶端2!".getBytes());
//        outputStream.close(); //關閉，否則服務器如果多次使用is.read的話，就會出現異常c
    }
}
