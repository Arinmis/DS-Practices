public class Player implements Comparable<Player>{

    private String name;
    private int speed;

    public Player(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return this.name;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "(Name: " + name + ", Speed: " + speed + ")";
    }

    public int compareTo(Player other) {
        if(this.speed > other.getSpeed())
            return 1;
        else if(this.speed == other.getSpeed())
            return 0;
        else
            return -1;
    }
}
