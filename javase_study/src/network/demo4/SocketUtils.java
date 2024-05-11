package network.demo4;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class SocketUtils {
    /*
     * 發送數據
     * @param socket
     * @param msg
     */
    public static void sendMsg(Socket socket, String msg) throws IOException {
        OutputStream outputStream = null;
        // 服務端給客戶端發送消息
        outputStream = socket.getOutputStream();
        outputStream.write(msg.getBytes());
    }

    /*
     *接受客戶端的消息
     * @param socket
     * @return
     */
    public static String receiveMsg(Socket socket) throws IOException {
        InputStream inputStream = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            // To display the client's message on the sever
            inputStream = socket.getInputStream();
            // 解決中文編譯的問題
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//            byte[] bytes = new byte[10];
            char[] chars = new char[1024];
            int len; // 實際讀取的長度

            do {
                len = inputStreamReader.read(chars);
//                System.out.println(new String(bytes, 0, len));
                stringBuffer.append(new String(chars, 0, len));

                if (inputStream.available() == 0) break;
            } while (true);
        } catch (Exception e) {
            throw new IOException(e);
        }

        return stringBuffer.toString();
    }
}
