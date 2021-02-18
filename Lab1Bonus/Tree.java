public class Tree {
    private Node root;
    private int nodes;
    public Tree(){ //creaza nodul radacina si apeleaza functia branching care creaza restul arborelui
        this.nodes = 1;
        this.root = new Node(1);
        while(Math.random() > 0.5) {
            this.nodes += 1;
            root.addChild(this.nodes);
        }
        this.branching(this.root);
    }
    private void branching(Node root){ //se apeleaza recursiv pentru fiecare nod al arborelui
        for(int i = 0; i < root.children.size(); i++){
            while(Math.random() > 0.5) {
                this.nodes += 1;
                root.children.get(i).addChild(this.nodes);
            }
            branching(root.children.get(i));
        }
    }
    private void traversal(Node root, int level){ //parcurge arborele si afizeaza valorile de pe noduri
        for(int i = 0; i < level; i++){
            System.out.print("  ");
        }
        if(root.children.isEmpty()){
            System.out.print("-node");
        }
        else{
            System.out.print("+node");
        }
        System.out.println(root.value);
        for(int i = 0; i < root.children.size(); i++) {
            traversal(root.children.get(i), level + 1);
        }
    }
    public void print(){
        this.traversal(this.root, 0);
    }
}
