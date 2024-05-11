package network.demo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    // 控制台網絡聊天室實現，只是服務端與多個客戶端
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);

        while (true) {
            Socket socket = serverSocket.accept(); // wait for the client to connect the sever itself
            System.out.println(socket);

            new Thread(() -> {
                while (true) {
                    // To display the client's message on the sever
                    InputStream inputStream = null;
                    try {
                        inputStream = socket.getInputStream();
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        char[] buffer = new char[1024];
                        int len; // 實際讀取的長度
                        while ((len = inputStreamReader.read(buffer)) != -1) {
                            System.out.println(new String(buffer, 0, len));
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }

//       socket.close();
//       serverSocket.close();

    }
}
