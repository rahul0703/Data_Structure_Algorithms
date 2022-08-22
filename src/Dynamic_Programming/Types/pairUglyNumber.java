package Dynamic_Programming.Types;

public class pairUglyNumber implements Comparable<pairUglyNumber>{
    int number;
    int index = -1;

    public pairUglyNumber(int number, int index){
        this.number = number;
        this.index = index;
    }

    public int compareTo(pairUglyNumber o){
        return this.number - o.number;
    }
}
