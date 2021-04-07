package Board;

public class GameThread extends Thread{
    private final int playerIndex;
    private final Board board;
    private final boolean isAI;
    public GameThread(int playerIndex, Board board, boolean isAI) {
        this.playerIndex = playerIndex;
        this.board = board;
        this.isAI = isAI;
    }
    @Override
    public void run() {
        while (board.getTokens().size() > 1) {
            board.getPlayers().get(playerIndex).addToken(board.pickToken(board.getPlayers().get(playerIndex), isAI));
        }
        board.sumUpGame(playerIndex);
        board.determineWinner(playerIndex);
    }
}