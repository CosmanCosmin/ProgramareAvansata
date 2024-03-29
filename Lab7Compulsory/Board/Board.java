package Board;

import java.util.*;

public class Board {
    private List<Token> tokens;
    public Board(int n){
        tokens = new ArrayList<>();
        generateTokensOnBoard(n);
    }
    private void generateTokensOnBoard(int maxValue){
        Random random = new Random();
        int k = 0;
        for (int i = 0; i < maxValue; i++){
            for (int j = 0; j < maxValue; j++){
                if (i != j){
                    k += 1;
                    tokens.add(new Token("T" + k, i + 1, j + 1, random.nextInt(maxValue) + 1));
                }
            }
        }
        Collections.shuffle(tokens);
    }
    public synchronized List<Token> getTokens() {
        return tokens;
    }
    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }
    public synchronized Token pickToken(String name){
        System.out.println(this);
        int index;
        do {
            System.out.println(name + " choose a token based on its index:");
            Scanner scanner = new Scanner(System.in);
            index = scanner.nextInt();
            index = verify(index);
        } while (index == -1);
        Token token = tokens.get(index);
        tokens.remove(index);
        return token;
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
    @Override
    public String toString() {
        return String.valueOf(tokens);
    }
}
