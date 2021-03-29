package Board;

public class Token {
    private String name;
    private int left;
    private int right;
    private int value;
    public Token(String name, int left, int right, int value) {
        this.name = name;
        this.left = left;
        this.right = right;
        this.value = value;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLeft() {
        return left;
    }
    public void setLeft(int left) {
        this.left = left;
    }
    public int getRight() {
        return right;
    }
    public void setRight(int rightValue) {
        this.right = rightValue;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return  name +
                " with left = " + left +
                ", right = " + right +
                ", value = " + value + "\n";
    }
}
