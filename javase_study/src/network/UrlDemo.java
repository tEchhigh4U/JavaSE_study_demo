package network;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class UrlDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.google.com");
        InputStream inputStream = url.openStream();
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) != -1) {
            System.out.println(new String(bytes, 0, bytes.length));
        }
    }
}
