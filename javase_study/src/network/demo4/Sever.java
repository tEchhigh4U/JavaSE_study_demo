package network.demo4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class Sever {
    // 單對單聊天 - key-value pair -- 用戶名與Socket一一對應
    private static ConcurrentHashMap<String, Socket> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        // 調用單對單聊天的程序
        SendMessageToTargetClient();
    }

    // 控制台聊天室實現，客戶端與客戶端之間
    // 單對單聊天的功能實現
    public static void SendMessageToTargetClient() throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);

        while (true) {
            Socket socket = serverSocket.accept(); // accept方法，通常應用於--- 等客戶端來連結
            new ClientThread(socket, map).start(); // 線程需要啟動才能生成
        }
    }


    // 第一版寫法(基礎篇)
    public static void test() throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        Socket accept = serverSocket.accept(); // wait for the client to connect the sever itself
        System.out.println(accept);

        // 將客戶端發過過來的內容打印出來
        System.out.println(SocketUtils.receiveMsg(accept));

        // 服務器給客戶端發送消息
        SocketUtils.sendMsg(accept, "This is a message from server! 這是服務端的信息");

//        accept.close();
//        serverSocket.close();
    }
}
