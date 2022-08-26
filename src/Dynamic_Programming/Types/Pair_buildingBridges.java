package Dynamic_Programming.Types;

public class Pair_buildingBridges implements Comparable<Pair_buildingBridges>{
    int north;
    int south;

    public Pair_buildingBridges(int north, int south){
        this.north = north;
        this.south = south;
    }

    public int compareTo(Pair_buildingBridges o){
        return this.north - o.north;
    }

    public int getNorth() {
        return north;
    }

    public void setNorth(int north) {
        this.north = north;
    }

    public int getSouth() {
        return south;
    }

    public void setSouth(int south) {
        this.south = south;
    }
}
