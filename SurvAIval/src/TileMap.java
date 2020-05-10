import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

// This class 
public class TileMap {

    private Tile[] tiles;

    // If no passableChance value is passed, then it will be set to 1, ensuring all
    // tiles are passable
    TileMap(int width, int height) {
        this(width, height, 1, 0, 0, 0);
    }

    /**
     * Each tile type weight is the chance of that tile being generated compared to the sum of
     * all of the weights. If you don't want to worry about this, call the above constructor.
     *
     * @param width
     * @param height
     * @param dirtWeight
     * @param boulderWeight
     * @param waterWeight
     * @param treeWeight
     */
    TileMap(int width, int height, double dirtWeight, double boulderWeight, double waterWeight, double treeWeight) {

        Tile[] tiles = new Tile[width * height];
        double totalWeight = dirtWeight + boulderWeight + waterWeight + treeWeight;

        String type = "";
        double rand;
        int index = 0;

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                rand = Math.random() * totalWeight;
                if(rand <= dirtWeight) {
                    type = "dirt";
                }else if(rand <= dirtWeight + boulderWeight && rand >= dirtWeight) {
                    type = "boulder";
                }else if(rand <= dirtWeight + boulderWeight + waterWeight && rand >= dirtWeight + boulderWeight) {
                    type = "water";
                }else if(rand <= dirtWeight + boulderWeight + waterWeight + treeWeight && rand >= dirtWeight + boulderWeight + waterWeight) {
                    type = "tree";
                }
                tiles[index] = new Tile(i,j,type);
                index++;
            }
        }
        this.tiles = tiles;
    }

    // returns a tile of a certain index, may not be useful
    public Tile getTile(int i) {
        return tiles[i];
    }

    public int getSize() { return tiles.length; }

    // Loops through tiles array until a tile with the passed coords are found
    public Tile search(int x, int y) {
        for (Tile tile : tiles) {
            if (x == tile.getX() && y == tile.getY()) {
                return tile;
            }
        }
        return null; // Call isValid() first if you want to avoid getting returned null
    }

    // Returns boolean value based on if the passed in coords are within the tileMap bounds
    public boolean isValid(int x, int y) {
        Tile tile = search(x,y);
        return tile != null;
    }

    // Returns boolean value based on if the passed in coords are passable
    public boolean isPassable(int x, int y) {
        Tile tile = search(x,y);
        return tile != null && tile.isPassable();
    }

    //  Creates a list of all tiles with food
    public List<Tile> createFoodList() {
        List<Tile> food = new ArrayList();
        for (Tile tile : tiles) {
            if (tile.containsFood()) {
                food.add(tile);
            }
        }
        return food;
    }

    // Populates map with food. If there are no more available tiles it stops.
    public void populateMapWithFood(int foodCount) {
        populateMap("food",foodCount);
    }

    public void populateMapWithCritters(int critterCount) {
        populateMap("critter",critterCount);
    }

    public void populateMap(String type, int count) {
        List<Tile> dirt = new ArrayList();
        for (Tile tile : tiles) {
            if (tile.getType().equals("dirt")) {
                dirt.add(tile);
            }
        }
        int rand;

        for (int i = 0; i < count; i++) {
            try {
                rand = ThreadLocalRandom.current().nextInt(0, dirt.size());
                dirt.get(rand).setType(type);
                dirt.remove(rand);
            }catch (Exception e) {

            }
        }
    }

    @Override
    public String toString() {
        return "\nMap Info:" +
                "\nTiles: " + Arrays.toString(tiles);
    }
}
