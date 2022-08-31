package Binary_Tree.Types;

public class Pair_tree_ancester_matrix implements Comparable<Pair_tree_ancester_matrix>{
    int num;
    int count;

    public Pair_tree_ancester_matrix(int num, int count){
        this.num = num;
        this.count = count;
    }

    public int compareTo(Pair_tree_ancester_matrix o){
        return o.count-this.count;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
