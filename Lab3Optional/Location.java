import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public abstract class Location {
    private String name;
    private Map<Location, Duration> travelTimes = new HashMap<>();
    public Location(String name){
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setTravelTimes(Map<Location, Duration> travelTime) {
        this.travelTimes = travelTime;
    }
    public Map<Location, Duration> getTravelTimes() {
        return travelTimes;
    }
    public void addTravelTime(Location location, Duration time){
        travelTimes.put(location, time);
    }
}
