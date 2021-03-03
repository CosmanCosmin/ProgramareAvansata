import java.util.List;

public class City {
    private List<Location> locations;
    public City(List<Location> locations){
        this.locations = locations;
    }
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
    public List<Location> getLocations() {
        return locations;
    }
}
