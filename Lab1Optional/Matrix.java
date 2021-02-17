import java.util.Arrays;

public class Matrix {
    private boolean[][] matrix;
    private boolean[][] partialMatrix;
    private int n;
    private boolean[] visited;
    private void dfs(int currentNode, boolean print){
        this.visited[currentNode] = true;
        if (print) {
            System.out.print(currentNode + " ");
        }
        for(int i = 0; i < this.n; i++){
            if(this.matrix[currentNode][i]){
                if(!this.visited[i]){
                    this.partialMatrix[currentNode][i] = this.partialMatrix[i][currentNode] = true;
                    dfs(i, print);
                }
            }
        }
    }
    public Matrix(int n){
        this.n = n;
        this.matrix = new boolean[n][n];
        this.partialMatrix = new boolean[n][n];
        this.visited = new boolean[n];
    }
    public void createMatrix(){
        float percentage;
        if (this.n > 1000) {
            percentage = (float) 1 / this.n;
        }
        else {
            percentage = (float) 1 / 2;
        }
        for(int i = 0; i < this.n; i++){
            for (int j = i; j < this.n; j++){
                if(i == j) {
                    this.matrix[i][j] = false;
                }
                else {
                    if (Math.random() < percentage){
                        this.matrix[j][i] = this.matrix[i][j] = true;
                    }
                    else {
                        this.matrix[j][i] = this.matrix[i][j] = false;
                    }
                }
            }
        }
    }
    public boolean isConnected(){
        dfs(0, false);
        for (int i = 0; i < this.n; i++){
            if(!this.visited[i]){
                return false;
            }
        }
        return true;
    }
    public void findConnectedComponents(){
        Arrays.fill(this.visited, false);
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i,true);
                System.out.println();
            }
        }
    }
    public void print(){
        for (int i = 0; i < this.n; i++){
            for (int j = 0; j < this.n; j++){
                if(this.matrix[i][j]) {
                    System.out.print(1 + " ");
                }
                else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }
    public void printPartial(){
        for (int i = 0; i < this.n; i++){
            for (int j = 0; j < this.n; j++){
                if(this.partialMatrix[i][j]) {
                    System.out.print(1 + " ");
                }
                else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }
}