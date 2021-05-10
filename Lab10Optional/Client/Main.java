import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int PORT = 43334;
        try {
            Socket socket = new Socket(serverAddress, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request;
            Scanner scanner = new Scanner(System.in);
            do {
                // send a request to the server
                request = scanner.nextLine().trim();
                out.println(request);
                // wait for server response
                String response = in.readLine();
                System.out.println(response);
            }
            while (!request.equals("exit") && !request.equals("stop"));
        } catch (IOException e) {
            System.err.println("No server listening..." + e);
        }
    }
}
