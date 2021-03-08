public class Hotel extends Location implements Classifiable{
    private int rank;
    public Hotel(String name, int rank) {
        super(name);
        this.rank = rank;
    }
    @Override
    public void setRank(int rank) {
        this.rank = rank;
    }
    @Override
    public int getRank(int rank) {
        return this.rank;
    }
    @Override
    public String toString() {
        return "Hotel{" +
                "name" + this.getName() +
                ", rank=" + rank +
                '}';
    }
}
