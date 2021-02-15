//Laborator1 Programare Avansata
public class Main {
    public static void main(String[] args){
        System.out.println("Hello World!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "Javascript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1000000);
        //System.out.println(n);
        n = (n * 3 + Integer.parseInt("10101",2) + Integer.parseInt("FF", 16)) * 6;
        //System.out.println(n);
        while(n > 9) {
            int result = 0;
            while(n != 0){
                result = result + n % 10;
                n = n / 10;
            }
            n = result;
        }
        //System.out.println(n);
        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
    }
}
