import java.util.HashMap;
import java.util.Map;

public abstract class Location {
    private String name;
    private Map<Location, Time> travelTimes;
    public Location(String name){
        travelTimes = new HashMap<>();
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setTravelTimes(Map<Location, Time> travelTime) {
        this.travelTimes = travelTime;
    }
    public Map<Location, Time> getTravelTimes() {
        return travelTimes;
    }
    public void addTravelTime(Location location, Time time){
        travelTimes.put(location, time);
    }
}
