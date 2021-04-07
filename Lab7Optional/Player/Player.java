package Player;

import Board.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player{
    private List<Token> tokens;
    private String name;
    private int score = 0;
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
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    @Override
    public String toString() {
        return "Player: " + name + " has " + tokens + "\n";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(tokens, name);
    }
}