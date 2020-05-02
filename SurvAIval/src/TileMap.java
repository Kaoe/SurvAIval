import java.awt.*;
import java.util.Arrays;

// This class 
public class TileMap {

    private Tile[] tiles;

    // Constructor for TileMap
    // Accepts 2 ints
    TileMap(int width, int height) {

        Tile[] tiles = new Tile[width * height];

        int index = 0;
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                tiles[index] = new Tile(new int[]{i,j});
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
    public Tile search(int[] coords) {
        Tile tile = new Tile();
        for(int i = 0; i < tiles.length; i++) {
            if(coords == tiles[i].getCoords()) {
                tile =  tiles[i];
            }else {
                System.out.println("Tile not found");
            }
        }
        return tile;
    }

    public boolean isPassable(int[] coords) {
        return search(coords).isPassable();
    }

    @Override
    public String toString() {
        return "Map{" +
                "tiles=" + Arrays.toString(tiles) +
                '}';
    }
}