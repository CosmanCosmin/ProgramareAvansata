import java.util.ArrayList;

public class Solution {
    ArrayList<String> steps = new ArrayList<>();

    /**
     * Brute force attempt at solving the problem, solves the problem if the sum of
     * supplies and demands are equal but doesn't guarantee a minimized total cost of
     * transportation. The algorithm takes all the sources in order and gives all the
     * supplies to the first destination that demands it, if the supply is smaller or
     * equal to the demand then we subtract the supply from the demand and move to the
     * next source otherwise we subtract the demand from the supply and move to the
     * next destination.
     * @param problem the problem that is to be solved
     * @see Problem
     */
    public Solution(Problem problem){
        int totalCost = 0;
        Source[] sources = problem.getSources();
        Destination[] destinations = problem.getDestinations();
        int[][] costMatrix = problem.getCostMatrix();
        for(int i = 0; i < sources.length; i++){
            for(int j = 0; j < destinations.length; j++){
                if(sources[i].getSupply() == 0){
                    break;
                }
                if(destinations[j].getDemand() != 0) {
                    if (sources[i].getSupply() <= destinations[j].getDemand()) {
                        totalCost += sources[i].getSupply() * costMatrix[i][j];
                        steps.add(sources[i].getName() + " -> " + destinations[j].getName() + ": " + sources[i].getSupply() + " units * cost " + costMatrix[i][j] + " = " + (sources[i].getSupply() * costMatrix[i][j]) + "\n");
                        destinations[j].setDemand(destinations[j].getDemand() - sources[i].getSupply());
                        sources[i].setSupply(0);
                    } else {
                        totalCost += destinations[j].getDemand() * costMatrix[i][j];
                        steps.add(sources[i].getName() + " -> " + destinations[j].getName() + ": " + destinations[j].getDemand() + " units * cost " + costMatrix[i][j] + " = " + (destinations[j].getDemand() * costMatrix[i][j]) + "\n");
                        sources[i].setSupply(sources[i].getSupply() - destinations[j].getDemand());
                        destinations[j].setDemand(0);
                    }
                }
            }
        }
        steps.add("Total cost:" + totalCost);
    }
    public ArrayList<String> getSteps() {
        return steps;
    }
    public void setSteps(ArrayList<String> steps) {
        this.steps = steps;
    }
    /**
     * Overridden member of the Object class, used to print this object
     * @return the composition of the object as in the cost matrix, the list of sources and the list of destinations
     */
    @Override
    public String toString() {
        return "Solution{" +
                "steps=" + steps +
                '}';
    }
}
