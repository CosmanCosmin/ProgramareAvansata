import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class City {
    private List<Location> locations;
    public City(List<Location> locations){
        this.locations = new ArrayList<>();
        this.locations = locations;
    }
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
    public List<Location> getLocations() {
        return locations;
    }
    /**
     * prints all the locations that are part of the city and are Visitable but are not Payable
     * by going through all of them and checking the condition and if they match the condition
     * they are added to a SortedMap so that they get automatically sorted
     */
    public void printFreeVisitable(){
        SortedMap<LocalTime, Location> map = new TreeMap<>();
        for (Location location : locations) {
            if(location instanceof Visitable && !(location instanceof Payable)){
                map.put(((Visitable) location).getOpeningHours(), location);
            }
        }
        int count = 0;
        for (LocalTime mapKey : map.keySet()) {
            count++;
            System.out.print(count + ". ");
            System.out.println(map.get(mapKey));
        }
    }
}
