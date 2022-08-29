package Binary_Tree.Types;

public class NodeWithTask {
    Node node;
    int task;

    public NodeWithTask(Node node, int task){
        this.node = node;
        this.task = task;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public int getTask() {
        return task;
    }

    public void setTask(int task) {
        this.task = task;
    }
}
