import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket = null;
    public ClientThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            String request;
            do {
                // get the client input
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                request = in.readLine();
                // fulfill the request

                // send the response
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String response = "Server received the request:  " + request + "!";
                out.println(response);
                out.flush();
                if (request.equals("stop")){
                    System.exit(0);
                }
            } while (!request.equals("exit"));
        } catch (IOException e) {
            System.out.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
