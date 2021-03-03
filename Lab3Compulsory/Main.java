import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Location v1 = new Hotel("Hotel", 7);
        Location v2 = new Museum("Museum A", 10, new Time(9, 30), new Time(21, 0));
        Location v3 = new Museum("Museum B", 9, new Time(7, 0), new Time(21, 0));
        Location v4 = new Church("Church A", new Time(7, 0), new Time(21, 0));
        Location v5 = new Church("Church B", new Time(7, 0), new Time(21, 0));
        Location v6 = new Restaurant("Restaurant", 10);
        List<Location> locations = new ArrayList<>();
        v1.addTravelTime(v2, new Time(0, 10));
        v1.addTravelTime(v3, new Time(0, 50));
        locations.add(v1);
        v2.addTravelTime(v3, new Time(0, 20));
        v2.addTravelTime(v4, new Time(0, 20));
        v2.addTravelTime(v5, new Time(0, 10));
        locations.add(v2);
        v3.addTravelTime(v2, new Time(0, 20));
        v3.addTravelTime(v4, new Time(0, 20));
        locations.add(v3);
        v4.addTravelTime(v5, new Time(0, 30));
        v4.addTravelTime(v6, new Time(0, 10));
        locations.add(v4);
        v5.addTravelTime(v4, new Time(0, 30));
        v5.addTravelTime(v6, new Time(0, 20));
        locations.add(v5);
        locations.add(v6);
        City city = new City(locations);
    }
}
