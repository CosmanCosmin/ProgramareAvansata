package Base;

import Board.*;
import Player.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(4);
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
        new GameThread(firstPlayer, board, isFirstAI).start();
        new GameThread(secondPlayer, board, isSecondAI).start();
    }
}