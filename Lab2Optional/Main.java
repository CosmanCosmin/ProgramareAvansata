public class Main {
    public static void main(String[] args) {
        Factory S1 = new Factory("S1", 10);
        Warehouse S2 = new Warehouse("S2", 35);
        Warehouse S3 = new Warehouse("S3", 25);
        Destination D1 = new Destination("D1", 20);
        Destination D2 = new Destination("D2", 25);
        Destination D3 = new Destination("D3", 25);
        int[][] costMatrix = {{2, 3, 1}, {5, 4, 8}, {5, 6, 8}};
        Problem problem = new Problem(costMatrix, new Source[]{S1, S2, S3}, new Destination[]{D1, D2, D3});
        Solution solution = new Solution(problem);
        System.out.println(solution);
    }
}
