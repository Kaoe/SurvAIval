import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {

        TileMap tileMap = new TileMap(50,50);

        Critter critter = new Critter(tileMap,0,1,0,0);

        System.out.println(critter.toString());

        critter.pathfind(49,49);

        System.out.println(critter.toString());

        critter.completePath();

        System.out.println(critter.toString());


        System.out.println("\nRandom thought of " + critter.getName() + ": " + critter.generateRandomThought());



//        Tile tile = null;
//
//        tile = tileMap.search(7,12);
//
//        System.out.println(tile.toString());
//
//        tile.isPassable();
//
//        System.out.println(tileMap.isValid(9,4));
//        System.out.println(tileMap.isPassable(9,4));



//        Critter critter = new  Critter(0,1,0,0);
//
//        critter.doRandom(10);
//        System.out.println(critter.toString());
//
//        TileMap tileMap = new TileMap(3,4);
//
//        System.out.println(tileMap.toString());
//
//
//        List open = new ArrayList();
//        List closed = new ArrayList();
//        open.add(tileMap.getTile(2));






    }
}
