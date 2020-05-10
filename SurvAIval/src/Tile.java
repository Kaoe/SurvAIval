import java.util.Arrays;

// This class contains information about any
// given tile such as its location and physics

public class Tile {

	// The location of a tile on the tileMap
    private int x;
    private int y;
    private String type;

    // Indicates whether a tile can be walked through or not
    private boolean passable;

    public Tile(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
        switch (type) {
            case "dirt":
            case "tree":
            case "critter":
                this.passable = true;
                break;
            case "boulder":
            case "water":
                this.passable = false;
                break;
        }
    }

    public Tile(int x, int y, boolean passable) {
        this.x = x;
        this.y = y;
        this.passable = passable;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public String getType() { return type; }

    public void setType(String type) {
        this.type = type;
    }


    public boolean isPassable() {
    	return passable;
    	}

    @Override
    public String toString() {
        return "\nTile Info:" +
                "\nCoordinates: (" + x +", " + y + ")" +
                "\nPassable:" + passable + "\n";
    }
}
