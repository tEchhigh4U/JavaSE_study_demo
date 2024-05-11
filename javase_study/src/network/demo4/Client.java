package network.demo4;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 3000);

        System.out.println("Please enter your user name");
        Message msg = new Message();
        Scanner scanner = new Scanner(System.in);
        msg.setMsgFrom(scanner.nextLine());

        // 輸入接受者的名稱
        System.out.println("Please input the receiver's name(by user name)");
        msg.setMsgTo(scanner.nextLine());

        // 輸入發送的內容
        System.out.println("Please enter your message content");
        msg.setMsgContent(scanner.nextLine());

        // 將JSON轉話為String
        SocketUtils.sendMsg(socket, JSON.toJSONString(msg));
//        outputStream.close(); // 關閉，否則服務器如果多次使用is.read的話，就會出現異常Connection reset

        // 客戶端讀取其他客戶端發送的消息
        System.out.println("Message is receiving from the client sides now.");
        while (true) {
            System.out.println(SocketUtils.receiveMsg(socket));
        }

    }
}
