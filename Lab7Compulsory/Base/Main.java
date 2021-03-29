package Base;

import Board.*;
import Player.Player;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(4);
        Player firstPlayer = new Player("Ionut");
        Player secondPlayer = new Player("Andrei");
        new GameThread(firstPlayer, board).start();
        new GameThread(secondPlayer, board).start();
    }
}
