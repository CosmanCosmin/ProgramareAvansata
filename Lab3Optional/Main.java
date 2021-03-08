import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Location v1 = new Hotel("Hotel", 7);
        Location v2 = new Museum("Museum A", 10, LocalTime.of(9,30), LocalTime.of(21,0));
        Location v3 = new Museum("Museum B", 9, LocalTime.of(7,0), LocalTime.of(21,0));
        Location v4 = new Church("Church A", LocalTime.of(8,0), LocalTime.of(21,0));
        Location v5 = new Church("Church B", LocalTime.of(7,0), LocalTime.of(21,0));
        Location v6 = new Restaurant("Restaurant", 10);
        List<Location> locations = new ArrayList<>();
        v1.addTravelTime(v2, Duration.ofMinutes(10));
        v1.addTravelTime(v3, Duration.ofMinutes(50));
        locations.add(v1);
        v2.addTravelTime(v3, Duration.ofMinutes(20));
        v2.addTravelTime(v4, Duration.ofMinutes(20));
        v2.addTravelTime(v5, Duration.ofMinutes(10));
        locations.add(v2);
        v3.addTravelTime(v2, Duration.ofMinutes(20));
        v3.addTravelTime(v4, Duration.ofMinutes(20));
        locations.add(v3);
        v4.addTravelTime(v5, Duration.ofMinutes(30));
        v4.addTravelTime(v6, Duration.ofMinutes(10));
        locations.add(v4);
        v5.addTravelTime(v4, Duration.ofMinutes(30));
        v5.addTravelTime(v6, Duration.ofMinutes(20));
        locations.add(v5);
        locations.add(v6);
        City city = new City(locations);
        city.printFreeVisitable();
        int[][] preferenceMatrix = {{0, 1, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0}, {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}};
        TravelPlan travelPlan = new TravelPlan(city, preferenceMatrix);
        System.out.println(travelPlan.shortestPath(v1, v6));
    }
}
