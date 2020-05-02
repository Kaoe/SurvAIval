import java.util.Arrays;

// This class contains information about any
// given tile such as its location and physics
public class Tile {
	// The current location of a tile on the tilemap
    private int[] coords;
    // Indicates whether a tile can be walked through or not
    private boolean passable;

    // Getter for coords
    public int[] getCoords() {
    	return coords;
    	}
    // Getter for passable
    public boolean isPassable() {
    	return passable;
    	}

    // Set the location of the tile
    public Tile(int[] coords) {
        this.coords = coords;
    }

    // ???
    Tile() { }

    // Override the default toString method
    // Displays basic info about a Tile
    @Override
    public String toString() {
        return "\nTile Info:\n" +
        	"Coords: " + Arrays.toString(coords) +
                "\nPassable: " + passable;
    }
}
