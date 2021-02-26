public class Main {
    public static void main(String[] args) {
        Source S1 = new Source("S1", Source.SourceType.FACTORY, 10);
        Source S2 = new Source("S2", Source.SourceType.WAREHOUSE, 35);
        Source S3 = new Source("S3", Source.SourceType.WAREHOUSE, 25);
        Destination D1 = new Destination("D1", 20);
        Destination D2 = new Destination("D2", 25);
        Destination D3 = new Destination("D3", 25);
        System.out.println(S1);
        System.out.println(S2);
        System.out.println(S3);
        System.out.println(D1);
        System.out.println(D2);
        System.out.println(D3);
        int[][] costMatrix = {{2, 3, 1}, {5, 4, 8}, {5, 6, 8}};
        Problem problem = new Problem(costMatrix, new Source[]{S1, S2, S3}, new Destination[]{D1, D2, D3});
        System.out.println(problem);
        problem.print();
    }
}
