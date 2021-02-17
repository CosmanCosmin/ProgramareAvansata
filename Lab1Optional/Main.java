public class Main {
    public static void main(String[] args) {
        long t1 = System.nanoTime();
        int n = 0;
        try{
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
            System.exit(0);
        }
        if(n % 2 == 0) {
            System.out.println("Not an odd number");
            System.exit(0);
        }
        Matrix matrix = new Matrix(n);
        matrix.createMatrix();
        if(n < 30000){
            matrix.print();
        }
        else {
            System.out.println("Large number.");
        }
        if(matrix.isConnected()){
            System.out.println("Graph is connected! Partial tree adjacency matrix:");
            if(n < 30000){
                matrix.printPartial();
            }
            else {
                System.out.println("Large number.");
            }
        }
        else {
            System.out.println("Graph is not connected! Connected components are:");
            matrix.findConnectedComponents();
        }
        long t2 = System.nanoTime();
        System.out.println("Runtime in nanoseconds:" + (t2 - t1));
    }
}
