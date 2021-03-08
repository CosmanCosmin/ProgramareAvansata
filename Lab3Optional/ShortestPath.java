import java.time.Duration;
import java.util.Arrays;

public class ShortestPath {
    private final Duration[] shortestPath;
    private final boolean[] visited;
    private final int[] previousIndex;
    private final TravelPlan travelPlan;
    /**
     * instantiates the required arrays to use Dijkstra's algorithm conforming to the
     * given travelPlan
     * @param travelPlan the given travelPlan
     */
    public ShortestPath(TravelPlan travelPlan){
        this.travelPlan = travelPlan;
        shortestPath = new Duration[travelPlan.getCity().getLocations().size()];
        visited = new boolean[travelPlan.getCity().getLocations().size()];
        previousIndex = new int[travelPlan.getCity().getLocations().size()];
        Arrays.fill(shortestPath, Duration.ofMinutes(Integer.MAX_VALUE));
        Arrays.fill(visited, false);
        Arrays.fill(previousIndex, -1);
    }

    /**
     * implements Dijkstra's shortest path algorithm to find the shortest path from the given
     * location to all other locations in the city by visiting  all of the current location unvisited neighbors
     * and calculating the paths between them
     * @param currentIndex the index representing the current location
     */
    private void pathing(int currentIndex){
        for (int index = 0; index < visited.length; index++) {
            if(travelPlan.getPreferences()[currentIndex][index] == 1 && !visited[index]){
                Duration distance = shortestPath[currentIndex].plus(travelPlan.getCity().getLocations().get(currentIndex).getTravelTimes().get(travelPlan.getCity().getLocations().get(index)));
                if(distance.compareTo(shortestPath[index]) < 0){
                    shortestPath[index] = distance;
                    previousIndex[index] = currentIndex;
                }
            }
        }
        for (int index = 0; index < visited.length; index++) {
            if(travelPlan.getPreferences()[currentIndex][index] == 1 && !visited[index]){
                pathing(index);
            }
        }
        visited[currentIndex] = true;
    }

    /**
     * recursively traces back to the start of the path and then prints the locations part of it
     * @param current the current index corresponding location
     * @param start the location from where the path starts
     */
    private void printPathBetween(int current, int start){
        if(current != start){
            printPathBetween(previousIndex[current], start);
        }
        System.out.println(travelPlan.getCity().getLocations().get(current) + " ");
    }
    /**
     * calls the pathing method and checks to see if a path has been found from startingIndex to finish,
     * if not it prints that there's no path and exits, otherwise it calls the function that prints the path
     * and returns the time between the two locations
     * @param startingIndex the index from where the path should start
     * @param finish the index where the path should finish
     * @return the time it takes to go from the location corresponding to the starting index
     * to the one corresponding to the finish
     */
    public Duration getPathBetween(int startingIndex, int finish){
        shortestPath[startingIndex] = Duration.ofMinutes(0);
        pathing(startingIndex);
        if(shortestPath[finish].compareTo(Duration.ofMinutes(Integer.MAX_VALUE)) == 0){
            System.out.println("There's no path");
            System.exit(-1);
        }
        System.out.println("The path is:");
        printPathBetween(finish, startingIndex);
        return shortestPath[finish];
    }
}
