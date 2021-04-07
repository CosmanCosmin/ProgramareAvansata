package Board;

import Player.*;

public class Score {
    private final Player player;
    private int score = 0;
    public Score(Player player) {
        this.player = player;
        calculateScore();
    }
    private void calculateScore(){
        int cycleScore = player.getTokens().get(0).getValue();
        int cycleLength = 1;
        int cycleStartValue = player.getTokens().get(0).getLeft();
        int cycleCurrentValue = player.getTokens().get(0).getRight();
        for (int index = 1; index < player.getTokens().size(); index++){
            if (cycleStartValue == cycleCurrentValue){
                score += cycleLength * cycleScore;
                cycleScore = 0;
                cycleLength = 1;
                cycleStartValue = player.getTokens().get(index - 1).getLeft();
                cycleCurrentValue = player.getTokens().get(index - 1).getRight();
            }
            if (cycleCurrentValue == player.getTokens().get(index).getLeft()){
                cycleCurrentValue = player.getTokens().get(index).getRight();
                cycleLength += 1;
                cycleScore += player.getTokens().get(index).getValue();
            }
            else {
                score += cycleScore;
                cycleScore = player.getTokens().get(index).getValue();
                cycleLength = 1;
                cycleStartValue = player.getTokens().get(index).getLeft();
                cycleCurrentValue = player.getTokens().get(index).getRight();
            }
        }
        if (cycleStartValue == cycleCurrentValue){
            score += cycleLength * cycleScore;
        }
        else {
            score += cycleScore;
        }
    }
    public int getScore() {
        return score;
    }
}
