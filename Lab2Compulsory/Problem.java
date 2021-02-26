import java.util.Arrays;

public class Problem {
    private int[][] costMatrix;
    private Source[] sources;
    private Destination[] destinations;
    public Problem(int[][] costMatrix, Source[] sources, Destination[] destinations){
        this.costMatrix = costMatrix;
        this.sources = sources;
        this.destinations = destinations;
    }
    public int[][] getCostMatrix() {
        return costMatrix;
    }
    public void setCostMatrix(int[][] costMatrix) {
        this.costMatrix = costMatrix;
    }
    public Source[] getSources() {
        return sources;
    }
    public void setSources(Source[] sources) {
        this.sources = sources;
    }
    public Destination[] getDestinations() {
        return destinations;
    }
    public void setDestinations(Destination[] destinations) {
        this.destinations = destinations;
    }
    // afiseaza tabelul care descrie problema (pentru ca nu stiu daca puteam sa fac override la toString sa faca asta)
    public void print(){
        System.out.print("   ");
        for ( Destination x: destinations) {
            System.out.print(x.getName() + " ");
        }
        System.out.println("SU");
        for (int i = 0; i < sources.length; i++) {
            System.out.print(sources[i].getName() + " ");
            for (int j = 0; j < destinations.length; j++) {
                System.out.print(costMatrix[i][j] + "  ");
            }
            System.out.println(sources[i].getSupply());
        }
        System.out.print("DE ");
        for (Destination x: destinations) {
            System.out.print(x.getDemand() + " ");
        }
    }
    @Override
    public String toString() {
        return "Problem{" +
                "costMatrix=" + Arrays.deepToString(costMatrix) +
                ", sources=" + Arrays.toString(sources) +
                ", destinations=" + Arrays.toString(destinations) +
                '}';
    }
}
