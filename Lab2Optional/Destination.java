public class Destination {
    private String name;
    private int demand;
    /**
     * Class constructor that creates an object with the given name and supply amount
     * @param name the string that represents the name of this object
     * @param demand the integer that represents the amount of commodities that this destination demands
     */
    public Destination(String name, int demand){
        this.name = name;
        this.demand = demand;
    }
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Gets the name of this source
     * @return the string that represents the name of the object
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the demand of this destination
     * @return the integer amount of amount of commodities that this destination demands
     */
    public int getDemand() {
        return demand;
    }
    public void setDemand(int demand) {
        this.demand = demand;
    }
    /**
     * Overridden member of the Object class, used to print this object
     * @return the composition of the object as in the name and the amount of units it demands
     */
    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                ", demand=" + demand +
                '}';
    }
    /**
     * Overridden member of the Object class, used to check if two objects are equal
     * two objects are equal if they have the same name
     * @param o the object to be verified if it's equal to this object
     * @return if the parameter object and this object are equal or not
     */
    @Override
    public boolean equals(Object o){
        if(o == this){
            return  true;
        }
        if(!(o instanceof Destination)){
            return false;
        }
        Destination d = (Destination) o;
        return name.compareTo(d.name) == 0;
    }
}