package network.demo4;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class ClientThread extends Thread {
    private Socket socket;
    private ConcurrentHashMap<String, Socket> map; //保存所有的客戶端

    public ClientThread(Socket socket, ConcurrentHashMap<String, Socket> map) {
        this.socket = socket;
        this.map = map;
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
                Message message = JSON.parseObject(content, Message.class);
                map.put(message.getMsgFrom(), socket);
                // 將信息發送給對方
                Socket socketTo = map.get(message.getMsgTo());
                if (socketTo != null) {
                    SocketUtils.sendMsg(socketTo, content);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}