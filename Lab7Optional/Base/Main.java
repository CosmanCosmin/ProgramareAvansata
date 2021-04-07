package Base;

import Board.*;
import Player.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("How many players?(0, 1, 2)");
        Scanner scanner = new Scanner(System.in);
        int gameCase;
        do {
            gameCase = scanner.nextInt();
        } while (gameCase > 2);
        boolean isFirstAI = true;
        boolean isSecondAI = true;
        if (gameCase == 2){
            isFirstAI = isSecondAI = false;
        }
        else if(gameCase == 1){
            isFirstAI = false;
        }
        Player firstPlayer = new Player("Ionut");
        Player secondPlayer = new Player("Andrei");
        List<Player> players = new ArrayList<>(); players.add(firstPlayer); players.add(secondPlayer);
        Board board = new Board(1000, players);
        Thread timer = new TimerThread(30);
        timer.setDaemon(true);
        timer.start();
        new GameThread(0, board, isFirstAI).start();
        new GameThread(1, board, isSecondAI).start();
    }
}