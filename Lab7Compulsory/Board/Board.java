package Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Board {
    private List<Token> tokens;
    private boolean available = true;
    public Board(int n){
        tokens = new ArrayList<>();
        generateTokensOnBoard(n);
    }
    private void generateTokensOnBoard(int maxValue){
        boolean[] leftValues = new boolean[maxValue];
        boolean[] rightValues = new boolean[maxValue];
        Random random = new Random();
        int leftValue;
        int rightValue;
        for (int i = 0; i < maxValue; i++){
            do {
                leftValue = random.nextInt(maxValue);
            } while (leftValues[leftValue]);
            do {
                rightValue = random.nextInt(maxValue);
            } while (rightValues[rightValue]);
            leftValues[leftValue] = rightValues[rightValue] = true;
            tokens.add(new Token("T" + (i + 1),leftValue + 1, rightValue + 1, random.nextInt(maxValue)));
        }
    }
    public List<Token> getTokens() {
        return tokens;
    }
    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }
    public synchronized Token pickToken(String name){
        System.out.println(this);
        System.out.println(name + " choose a token based on its index:");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        Token token = tokens.get(index - 1);
        tokens.remove(index - 1);
        return token;
    }
    @Override
    public String toString() {
        return String.valueOf(tokens);
    }
}
