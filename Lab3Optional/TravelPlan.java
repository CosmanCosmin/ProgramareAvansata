import java.time.Duration;

public class TravelPlan {
    private City city;
    private int[][] preferences;
    public TravelPlan(City city, int[][] preferences){
        this.city = city;
        this.preferences = preferences;
    }
    public void setCity(City city) {
        this.city = city;
    }
    public City getCity() {
        return city;
    }
    public void setPreferences(int[][] preferences) {
        this.preferences = preferences;
    }
    public int[][] getPreferences() {
        return preferences;
    }
    /**
     * checks if the locations are part of the same city as this travelPlan, if so
     * it creates a ShortestPath object and returns the time that it takes to traverse the path between
     * the two specified locations, otherwise it tells the user they're not part of the same city and exits
     * @param start the starting location
     * @param finish the ending location
     * @return the minimum time it takes to go between the two locations
     */
    public Duration shortestPath(Location start, Location finish){
        if(!city.getLocations().contains(start) || !city.getLocations().contains(finish)){
            System.out.println("Both locations must be part of the city");
            System.exit(-1);
        }
        int startIndex = city.getLocations().indexOf(start);
        int finishIndex = city.getLocations().indexOf(finish);
        ShortestPath path = new ShortestPath(this);
        return path.getPathBetween(startIndex, finishIndex);
    }
}
