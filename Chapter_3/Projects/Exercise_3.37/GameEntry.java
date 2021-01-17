public class GameEntry implements  Comparable<GameEntry>{
    private String name;
    private int score;

    public GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(GameEntry entry) {
        if(entry.getScore() == this.score)
            return 0;
        else if(entry.getScore() > this.score)
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + score + ")";
    }
}