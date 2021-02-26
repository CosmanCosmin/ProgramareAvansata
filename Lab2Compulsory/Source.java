public class Source {
    public enum SourceType {
        WAREHOUSE, FACTORY;
    }
    private String name;
    private SourceType type;
    private int supply;
    public Source(String name, SourceType type, int supply){
        this.name = name;
        this.type = type;
        this.supply = supply;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public SourceType getType() {
        return type;
    }
    public void setType(SourceType type) {
        this.type = type;
    }
    public int getSupply() {
        return supply;
    }
    public void setSupply(int supply) {
        this.supply = supply;
    }
    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", supply=" + supply +
                '}';
    }
}
