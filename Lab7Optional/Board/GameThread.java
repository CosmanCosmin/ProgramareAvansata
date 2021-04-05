package Board;

import Player.*;

public class GameThread extends Thread{
    private final Player player;
    private final Board board;
    private final boolean isAI;
    public GameThread(Player player, Board board, boolean isAI) {
        this.player = player;
        this.board = board;
        this.isAI = isAI;
    }
    @Override
    public void run() {
        while (!board.getTokens().isEmpty()) {
            player.addToken(board.pickToken(player.getName(), isAI));
        }
        System.out.print(player);
    }
}