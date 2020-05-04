import java.awt.*;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

// This class 
public class TileMap {

    private Tile[] tiles;
    private double passableChance;

    // If no passableChance value is passed, then it will be set to -1, ensuring all
    // tiles are passable
    TileMap(int width, int height) {
        this(width, height, -1);
    }

    /**
     * passableChance should be a double between 0.0 and 1.0. This is the chance that
     * any given tile is considered passable. This can later be used to for either tile
     * types as well.
     *
     * @param width
     * @param height
     * @param passableChance
     */
    TileMap(int width, int height, double passableChance) {

        Tile[] tiles = new Tile[width * height];
        this.passableChance = passableChance;
        boolean passable;
        double rand;
        int index = 0;

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                rand = Math.random();
                if(rand <= this.passableChance) {
                    passable = true;
                }else {
                    passable = false;
                }
                tiles[index] = new Tile(i,j,passable);
                index++;
            }
        }
        this.tiles = tiles;
    }

    // returns a tile of a certain index, may not be useful
    public Tile getTile(int i) {
        return tiles[i];
    }

    // Loops through tiles array until a tile with the passed coords are found
    public Tile search(int x, int y) {
        Tile tile = null;
        for(int i = 0; i < tiles.length; i++) {
            if(x == tiles[i].getX() && y == tiles[i].getY()) {
                return tiles[i];
            }
        }
        return null;
    }

    // Returns boolean value based on if the passed in coords are within the tileMap bounds
    public boolean isValid(int x, int y) {
        Tile tile = search(x,y);
        if(tile != null) {
            return true;
        }
        return false;
    }

    public boolean isPassable(int x, int y) {
        return search(x,y).isPassable();
    }

    @Override
    public String toString() {
        return "Map{" +
                "tiles=" + Arrays.toString(tiles) +
                '}';
    }
}