public class Factory extends Source{
    /**
     * Class constructor that creates an object with the given name and supply amount
     * @param name the string that represents the name of this object
     * @param supply the integer that represents the amount of a commodity it is able to supply to the destinations
     */
    public Factory(String name, int supply){
        this.setName(name);
        this.setSupply(supply);
    }
    /**
     * Overridden member of the Object class, used to print this object
     * @return the composition of the object as in the name and the supply amount
     */
    @Override
    public String toString() {
        return "Factory:\n" + "name: " + this.getName() + "\nsupply: " + this.getSupply();
    }
    /**
     * Overridden member of the Object class, used to check if two objects are equal
     * two objects are equal if they have the same name
     * @param o the object to be verified if it's equal to this object
     * @return if the parameter object and this object are equal or not
     */
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof Factory)){
            return false;
        }
        Factory f = (Factory) o;
        return getName().compareTo(f.getName()) == 0;
    }
}
