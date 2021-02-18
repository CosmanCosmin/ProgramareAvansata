import java.util.ArrayList;
import java.util.List;
public class Node {
    public int value;
    public List<Node> children = new ArrayList<Node>();
    public Node(int value) {
        this.value = value;
    }
    public void addChild(int value){ //adauga un nou copil la lista copiilor nodului
        //System.out.println("Executia:" + (value - 1));
        Node temp = new Node(value);
        children.add(temp);
    }
}
