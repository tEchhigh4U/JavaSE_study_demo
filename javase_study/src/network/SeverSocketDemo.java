package network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SeverSocketDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        Socket socket = serverSocket.accept(); // wait for the client to connect the sever itself
        System.out.println(socket);
        // To display the client's message on the sever
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len; // 實際讀取的長度
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }

        socket.close();
        serverSocket.close();

    }
}
