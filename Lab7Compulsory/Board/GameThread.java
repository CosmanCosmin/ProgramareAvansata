package Board;

import Player.*;

public class GameThread extends Thread{
    private final Player player;
    private final Board board;
    public GameThread(Player player, Board board) {
        this.player = player;
        this.board = board;
    }
    @Override
    public void run() {
        while (!board.getTokens().isEmpty()) {
            player.addToken(board.pickToken(player.getName()));
            try {
                sleep(500);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        System.out.print(player);
    }
}
