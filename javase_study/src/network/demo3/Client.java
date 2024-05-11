package network.demo3;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 3000);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello I am client. 你好，我是客戶端!".getBytes());
        outputStream.close();
    }
}
