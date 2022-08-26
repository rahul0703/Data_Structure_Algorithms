package Binary_Tree;

import Binary_Tree.Types.Node;
import Binary_Tree.Types.Node_randomPointer;

public class Main {
    public static void main(String[] args){

        Node_randomPointer tree = new Node_randomPointer(1);
        tree.setLeft(new Node_randomPointer(2));
        tree.setRight(new Node_randomPointer(3));
        tree.getLeft().setLeft(new Node_randomPointer(4));
        tree.getLeft().setRight(new Node_randomPointer(5));
        tree.setRandom(tree.getLeft().getRight());
        tree.getLeft().getLeft().setRandom(tree);
        tree.getLeft().getRight().setRandom(tree.getRight());
        clone_with_random_pointer(tree);
    }

    public static void clone_with_random_pointer(Node_randomPointer node){
        Utility utility = new Utility();
        Node_randomPointer cloned_node = utility.clone_Tree_with_random_pointer(node);
        utility.Print_Tree_Pretty(cloned_node);
        utility.Print_Tree_Pretty(node);
    }
}
