
package Board;

import Player.*;

import java.util.*;

public class Board {
    private final List<Token> tokens;
    private final List<Player> players;
    private int playersTurn;
    private int firstPlayer;
    public boolean isGameOver = false;
    public Board(int n, List<Player> players){
        tokens = new ArrayList<>();
        this.players = players;
        generateTokensOnBoard(n);
    }
    private void generateTokensOnBoard(int maxValue){
        Random random = new Random();
        firstPlayer = random.nextInt(players.size());
        playersTurn = firstPlayer;
        int k = 0;
        for (int i = 0; i < maxValue; i++){
            for (int j = 0; j < maxValue; j++){
                if (i != j){
                    k += 1;
                    tokens.add(new Token("T" + k, i + 1, j + 1, random.nextInt(4) + 1));
                }
            }
        }
        Collections.shuffle(tokens);
    }
    public synchronized List<Token> getTokens() {
        return tokens;
    }
    public Token pickToken(Player player, boolean isAIPicking){
        synchronized (this) {
            while (!player.equals(players.get(playersTurn))) {
                try {
                    wait();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
            int index;
            if (!isAIPicking) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println(this);
                System.out.println(player);
                do {
                    System.out.println(player.getName() + " choose a token based on its index:");
                    Scanner scanner = new Scanner(System.in);
                    index = scanner.nextInt();
                    index = verify(index);
                } while (index == -1);
            } else {
                Random random = new Random();
                index = random.nextInt(tokens.size());
            }
            Token token = tokens.get(index);
            tokens.remove(index);
            System.out.println(player.getName() + " picked " + token.getName());
            if (playersTurn == 0) {
                playersTurn = 1;
            } else {
                playersTurn = 0;
            }
            notify();
            return token;
        }
    }
    public void sumUpGame(int index){
        synchronized (this) {
            while (!players.get(index).equals(players.get(playersTurn))) {
                try {
                    wait();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print(players.get(index));
            System.out.println(players.get(index).getName() + " has " + players.get(index).getTokens().size() + " tokens ");
            Score score = new Score(players.get(index));
            System.out.println(players.get(index).getName() + " managed to get " + score.getScore() + " points");
            players.get(index).setScore(score.getScore());
            if (playersTurn == 0) {
                playersTurn = 1;
            } else {
                playersTurn = 0;
            }
            notify();
            isGameOver = true;
        }
    }
    public void determineWinner(int index){
        synchronized (this) {
            while (!players.get(index).equals(players.get(playersTurn))) {
                try {
                    wait();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
            if (firstPlayer != index) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                if (players.get(0).getScore() > players.get(1).getScore()) {
                    System.out.println(players.get(0).getName() + " wins with a score of " +
                            players.get(0).getScore());
                } else {
                    if (players.get(0).getScore() < players.get(1).getScore()) {
                        System.out.println(players.get(1).getName() + " wins with a score of " +
                                players.get(1).getScore());
                    } else {
                        System.out.println(players.get(0).getName() + " and " + players.get(1).getName()
                                + " tie with a score of " + players.get(0).getScore());
                    }
                }
            }
            if (playersTurn == 0) {
                playersTurn = 1;
            } else {
                playersTurn = 0;
            }
            notify();
        }
    }
    private int verify(int index){
        String name = "T" + index;
        for (Token token: tokens) {
            if (token.getName().equals(name)){
                return tokens.indexOf(token);
            }
        }
        System.out.println("Invalid index");
        return -1;
    }
    public List<Player> getPlayers() {
        return players;
    }
    @Override
    public String toString() {
        return String.valueOf(tokens);
    }
}