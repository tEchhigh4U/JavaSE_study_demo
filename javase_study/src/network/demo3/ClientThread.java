package network.demo3;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class ClientThread extends Thread {
    private Socket socket;
    private CopyOnWriteArrayList<Socket> list; //保存所有的客戶端

    public ClientThread(Socket socket, CopyOnWriteArrayList<Socket> list) {
        this.socket = socket;
        this.list = list;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        while (true) {
            String content = null;
            try {
                // 客戶端發送消息過來後
                content = SocketUtils.receiveMsg(socket);
                //將這個消息發送給所有的客戶端
                for (int i = 0; i < list.size(); i++) {
                    SocketUtils.sendMsg(list.get(i), content);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}