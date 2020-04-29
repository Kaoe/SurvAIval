import java.util.Arrays;

public class Tile {

    private int[] coords;
    private boolean passable;

    public int[] getCoords() { return coords; }

    public boolean isPassable() { return passable; }

    public Tile(int[] coords) {
        this.coords = coords;
    }

    Tile() { }

    @Override
    public String toString() {
        return "Tile{" +
                "coords=" + Arrays.toString(coords) +
                ", passable=" + passable +
                '}';
    }
}
