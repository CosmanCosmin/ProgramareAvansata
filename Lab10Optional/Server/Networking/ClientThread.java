package Networking;

import Commands.*;
import SocialNetwork.SocialNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Arrays;

public class ClientThread extends Thread{
    private final Socket socket;
    private final SocialNetwork socialNetwork;
    private final ServerSocket serverSocket;
    private String name = "";
    public ClientThread(Socket socket, ServerSocket serverSocket, SocialNetwork socialNetwork) {
        this.socket = socket;
        this.serverSocket = serverSocket;
        this.socialNetwork = socialNetwork;
    }
    @Override
    public void run() {
        try {
            String request;
            do {
                // get the client input
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                try {
                    request = in.readLine();
                }
                catch (SocketTimeoutException exception){
                    out.println("Connection timed out.");
                    out.flush();
                    socket.close();
                    return;
                }
                // fulfill the request and send the response
                String response = "";
                if (!request.equals("stop")) {
                    String[] splitInput = request.split(" ");
                    System.out.println(splitInput[0]);
                    response = "Server received the request:  " + splitInput[0] + "! ";

                    switch (splitInput[0]){
                        case "register":
                            if (splitInput.length == 2) {
                                response = response + new RegisterCommand(socialNetwork).register(splitInput[1]);
                            }
                            else {
                                response = response + "Invalid number of arguments: " + (splitInput.length - 1) + ".";
                            }
                            break;
                        case "login":
                            if (splitInput.length == 2){
                                String loginAnswer = new LoginCommand(socialNetwork).login(splitInput[1]);
                                response = response + loginAnswer;
                                if (loginAnswer.split(" ")[0].equals("Successfully")) name = splitInput[1];
                            }
                            else {
                                response = response + "Invalid number of arguments: " + (splitInput.length - 1) + ".";
                            }
                            break;
                        case "friend":
                            if (!name.equals("")){
                                if (splitInput.length != 1){
                                    response = response + new FriendCommand(socialNetwork).
                                                          friend(name, Arrays.copyOfRange(splitInput, 1, splitInput.length));
                                }
                                else {
                                    response = response + "Invalid number of arguments: " + 0 + ".";
                                }
                            }
                            else {
                                response = response + "You have to be logged in.";
                            }
                            break;
                        case "send":
                            if (!name.equals("")){
                                if (splitInput.length == 2){
                                    response = response + new SendMessageCommand(socialNetwork).send(name, splitInput[1]);
                                }
                                else {
                                    response = response + "Invalid number of arguments: " + (splitInput.length - 1) + ".";
                                }
                            }
                            else {
                                response = response + "You have to be logged in.";
                            }
                            break;
                        case "read":
                            if (!name.equals("")){
                                if (splitInput.length == 1){
                                    response = response + new ReadMessagesCommand(socialNetwork).read(name);
                                }
                                else {
                                    response = response + "Invalid number of arguments: " + (splitInput.length - 1) + ".";
                                }
                            }
                            else {
                                response = response + "You have to be logged in.";
                            }
                            break;
                        default: response = "Invalid syntax: " + request;
                    }
                }
                else {
                    response = "Server stopped";
                }
                out.println(response);
                out.flush();
            } while (!request.equals("stop") && !request.equals("exit"));
            if (request.equals("stop")){
                serverSocket.close();
            }
        } catch (IOException e) {
            System.out.println("Communication error... ");
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
