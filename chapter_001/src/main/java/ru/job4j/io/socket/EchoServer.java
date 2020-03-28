package ru.job4j.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ru.job4j.io.socket.EchoServer
 *
 * @author romanvohmin
 * @version 0.1
 * @since 26.03.2020
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                        if (str.contains("Exit")) {
                            server.close();
                            System.out.println("Сервер закрыт");
                            break;
                        } else if (str.contains("Hello")) {
                            out.write("Hello\n".getBytes());
                        } else {
                            out.write(((str.substring((str.indexOf("=") + 1))).substring(0, (str.indexOf(" ") + 1)) + "\n").getBytes());
                    }
                    System.out.println(str);
                }
            }
        }
    }
}
