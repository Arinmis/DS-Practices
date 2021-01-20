public class PlayGround {
    private CircularlyLinkedList<Player> playGround;
    private double radiusOfCircle = 0;

    public PlayGround(double radiusOfCircle) {
        this.radiusOfCircle = radiusOfCircle;
        playGround = new CircularlyLinkedList<>();
    }

    public double getRadiusOfCircle() {
        return radiusOfCircle;
    }

    @Override
    public String toString() {
        return playGround.toString();
    }

    public double getPerimeter() {
        return 2 * Math.PI * radiusOfCircle;
    }

    public void addPlayer(Player player) {
        playGround.addLast(player);
    }

    public Player getPlayer(int index) {
       return (Player)getNode(index).getValue();
    }

    /* put given player to index and return that was in the index */
    public Player replace(Player it, int index) {
        CircularlyLinkedList.Node targetNode = getNode(index);
        Player newIt = (Player)targetNode.getValue();
        targetNode.setValue(it);
        return newIt;
    }

    public CircularlyLinkedList.Node getNode(int index) {
        if(index < 0 || index > playGround.getSize() - 1)
            throw new IndexOutOfBoundsException(index);

        CircularlyLinkedList.Node iterator = playGround.getTail().getNext();

        int count = 0;
        while(count < index) {
            iterator = iterator.getNext();
            count++;
        }

        return iterator;
    }
}
