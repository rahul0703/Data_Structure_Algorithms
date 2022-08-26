package Binary_Tree.Types;

public class Node_randomPointer {
    int val;
    Node_randomPointer left = null;
    Node_randomPointer right = null;
    Node_randomPointer random = null;

    public Node_randomPointer(int val){
        this.val = val;
    }

    public Node_randomPointer(Node_randomPointer node){
        this.val = node.val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node_randomPointer getLeft() {
        return left;
    }

    public void setLeft(Node_randomPointer left) {
        this.left = left;
    }

    public Node_randomPointer getRight() {
        return right;
    }

    public void setRight(Node_randomPointer right) {
        this.right = right;
    }

    public Node_randomPointer getRandom() {
        return random;
    }

    public void setRandom(Node_randomPointer random) {
        this.random = random;
    }
}
