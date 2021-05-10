package Networking;

import SocialNetwork.SocialNetwork;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 43334;
    public Server(){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            SocialNetwork socialNetwork = new SocialNetwork();
            while (true){
                System.out.println("Waiting for a client...");
                Socket socket = serverSocket.accept();
                socket.setSoTimeout(300000);
                new ClientThread(socket, serverSocket, socialNetwork).start();
            }
        } catch (IOException e) {
            System.err.println("Oops..." + e);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
