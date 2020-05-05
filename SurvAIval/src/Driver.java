import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {


        Critter critter = new  Critter(0,1,0,0);

        critter.doRandom(10);
        System.out.println(critter.toString());

        TileMap tileMap = new TileMap(3,4);

        System.out.println(tileMap.toString());


        List open = new ArrayList();
        List closed = new ArrayList();
        open.add(tileMap.getTile(2));






    }
}
