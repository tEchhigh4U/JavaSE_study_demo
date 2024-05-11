package network.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        Socket socket = serverSocket.accept(); // wait for the client to connect the sever itself
        System.out.println(socket);
        while (true) {
            // To display the client's message on the sever
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//       byte[] bytes = new byte[1024];
            char[] buffer = new char[1024];
            int len; // 實際讀取的長度
            while ((len = inputStreamReader.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, len));
            }
        }

//       socket.close();
//       serverSocket.close();

    }
}
