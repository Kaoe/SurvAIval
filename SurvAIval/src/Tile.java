import java.util.Arrays;

// This class contains information about any
// given tile such as its location and physics

public class Tile {

	// The location of a tile on the tileMap
    private int x;
    private int y;

    // Indicates whether a tile can be walked through or not
    private boolean passable;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Tile(int x, int y, boolean passable) {
        this.x = x;
        this.y = y;
        this.passable = passable;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public boolean isPassable() {
    	return passable;
    	}

    @Override
    public String toString() {
        return "\nTile Info:" +
                "\nCoordinates: (" + x +", " + y + ")" +
                "\nPassable:" + passable;
    }
}
