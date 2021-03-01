import java.util.Arrays;

public class Problem {
    private int[][] costMatrix;
    private Source[] sources;
    private Destination[] destinations;
    /**
     * checks if there are any duplicates in a given list of sources
     * two sources are equal if they are of the same type as in Warehouse or Factory and share the same name
     * @param sources the Source list to be checked for duplicates
     * @return if there exists a duplicated source in the given list
     * @see Warehouse
     * @see Factory
     */
    private boolean checkDuplicateSources(Source[] sources){
        for(int i = 0; i < sources.length - 1; i++){
            for (int j = i + 1; j < sources.length; j++){
                if(sources[i].equals(sources[j])){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * checks if there are any duplicates in a given list of destinations
     * two destinations are equal if they share the same name
     * @param destinations the Destination list to be checked for duplicates
     * @return if there exists a duplicated destination in the given list
     * @see Destination
     */
    private boolean checkDuplicateDestinations(Destination[] destinations){
        for(int i = 0; i < destinations.length - 1; i++){
            for (int j = i + 1; j < destinations.length; j++){
                if(destinations[i].equals(destinations[j])){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Class constructor that creates an object with the given costMatrix, list of sources and list of destinations
     * if there are duplicated sources or destinations in the given lists it will inform the user of this and the created object won't be created with the given list
     * @param costMatrix the two dimensional array used to store the cost of transporting a unit of commodity from each source to each destination
     * @param sources the list of sources
     * @param destinations the list of destinations
     * @see Main
     */
    public Problem(int[][] costMatrix, Source[] sources, Destination[] destinations){
        this.costMatrix = costMatrix;
        if(checkDuplicateSources(sources)){
            System.out.println("There are duplicate sources!");
        }
        else{
            this.sources = sources;
        }
        if(checkDuplicateDestinations(destinations)){
            System.out.println("There are duplicate destinations!");
        }
        else {
            this.destinations = destinations;
        }
    }

    /**
     * gets the cost matrix for this problem
     * @return the two dimensional array associated with this problem
     */
    public int[][] getCostMatrix() {
        return costMatrix;
    }
    public void setCostMatrix(int[][] costMatrix) {
        this.costMatrix = costMatrix;
    }
    /**
     * gets the list of sources for this problem
     * @return the array of sources associated with this problem
     */
    public Source[] getSources() {
        return sources;
    }
    public void setSources(Source[] sources) {
        if(checkDuplicateSources(sources)){
            System.out.println("There are duplicate sources!");
        }
        else{
            this.sources = sources;
        }
    }
    /**
     * gets the list of destinations for this problem
     * @return the array of destinations associated with this problem
     */
    public Destination[] getDestinations() {
        return destinations;
    }
    public void setDestinations(Destination[] destinations) {
        if(checkDuplicateDestinations(destinations)){
            System.out.println("There are duplicate destinations!");
        }
        else {
            this.destinations = destinations;
        }
    }
    /**
     * prints the table corresponding to this problem
     * similar to the one on the site
     * the table consists of the cost matrix in the middle, first row contains the names
     * of the sources and the last column on this row is named "SU" for supply, first column contains the names of
     * the destinations and the last row is named "DE" for demand, the last column and row
     * contain the respective supply/demand that associates to the source/destination
     * names on the first row/column
     */
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
    /**
     * Overridden member of the Object class, used to print this object
     * @return the composition of the object as in the cost matrix, the list of sources and the list of destinations
     */
    @Override
    public String toString() {
        return "Problem{" +
                "costMatrix=" + Arrays.deepToString(costMatrix) +
                ", sources=" + Arrays.toString(sources) +
                ", destinations=" + Arrays.toString(destinations) +
                '}';
    }
}