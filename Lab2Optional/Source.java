public abstract class Source {
    private String name;
    private int supply;
    public Source(){}
    /**
     * Gets the name of this source
     * @return the string that represents the name of the object
     */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Gets the supply of this source
     * @return the integer amount of units of a commodity it is able to supply to the destinations
     */
    public int getSupply() {
        return supply;
    }
    public void setSupply(int supply) {
        this.supply = supply;
    }
    @Override
    public abstract String toString();
    @Override
    public abstract boolean equals(Object o);
}