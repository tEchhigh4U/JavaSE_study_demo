package network.demo3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class Sever {
    // 保存所有的客戶端
    private static CopyOnWriteArrayList<Socket> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws IOException {
        SendMessageToClient();
    }

    // 控制台聊天室實現，客戶端與客戶端之間都能看到各自發送的最新消息
    public static void SendMessageToClient() throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);

        while (true) {
            // 等客戶端來連結
            Socket socket = serverSocket.accept();
            // 將客戶端的連結存入集合裡面
            list.add(socket);
            new ClientThread(socket, list).start();

        }

    }

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
