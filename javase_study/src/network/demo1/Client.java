package network.demo1;

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
        while (true) {
            outputStream.write(scanner.nextLine().getBytes());
        }

//        outputStream.write("Hello I am client1. 你好，我是客戶端1!".getBytes());
//        outputStream.write("Hello I am client2. 你好，我是客戶端2!".getBytes());
//        outputStream.close();
    }
}
