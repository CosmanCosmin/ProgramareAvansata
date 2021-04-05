package Player;

import Board.*;

import java.util.ArrayList;
import java.util.List;

public class Player{
    private List<Token> tokens;
    private String name;
    public Player(String name) {
        tokens = new ArrayList<>();
        this.name = name;
    }
    public void addToken(Token token){
        tokens.add(token);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Token> getTokens() {
        return tokens;
    }
    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }
    @Override
    public String toString() {
        return "Player: " + name + " has " + tokens + "\n";
    }
}