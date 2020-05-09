import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

//import static java.lang.Math.abs;

public class Critter {

    private String name;

    private TileMap tileMap;
    private int direction;
    private int moveSpeed;
    private int x;
    private int y;
    private List currentPath;// This is the path that the critter is currently taking. It is a list of directions
    public Critter(TileMap tileMap, int direction, int moveSpeed, int x, int y) {
        this.name = generateRandomName();
        this.tileMap = tileMap;
        this.direction = direction;
        this.moveSpeed = moveSpeed;
        this.x = x;
        this.y = y;
    }

    public String getName() { return name; }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void turnRight() {
        this.direction += 1;
        this.direction %= 4;
    }

    public void turnLeft() {
        this.direction += 3;
        this.direction %= 4;
    }

    public void moveForward() {
        if(direction == 0) {
            this.y += 1;
        }else if(direction == 1) {
            this.x +=1;
        }else if(direction == 2) {
            this.y-= 1;
        }else if(direction == 3) {
            this.x -= 1;
        }
    }

    public void pathfind(int xDest, int yDest) {
        currentPath = Node.pathfind(this.tileMap,this.x,this.y,xDest,yDest);
    }

    //  Takes one action to move along the path
    public void moveAlongPath() {
        if (currentPath.isEmpty()) {
//          doNext();                      This means that the action is complete, time to move onto the next task
        }else if (this.direction == ((int) currentPath.get(0) + 1) % 4) {
            turnLeft();
        }else if (this.direction == ((int) currentPath.get(0) + 3) % 4) {
            turnRight();
        }else if (this.direction == (int) currentPath.get(0)) {
            moveForward();
            currentPath.remove(0);
        }else {
            turnLeft();
        }
    }

    //  Moves along the path a certain amount of times
    public void moveAlongPath(int count) {
        for (int i = 0; i < count; i++) {
            moveAlongPath();
        }
    }

    //  Moves along the whole path
    public void completePath() {
        while (!currentPath.isEmpty()) {
            moveAlongPath();
        }
    }

    public void findClosestFood() {
        List<Tile> food = tileMap.createFoodList();
        List closestFoodPath = null;
        List possibleClosest;
        for (Tile tile : food) {
            possibleClosest = Node.pathfind(this.tileMap, this.x, this.y, tile.getX(), tile.getY());
            if (closestFoodPath == null || possibleClosest.size() < closestFoodPath.size()) {
                closestFoodPath = possibleClosest;
            }
        }
        currentPath = closestFoodPath;
    }

    public void doRandom() {
        int min = 1;
        int max = 3;
        int rand = ThreadLocalRandom.current().nextInt(min, max + 1); // chooses rand int

        switch (rand) {
            case 1: turnRight();
                    break;
            case 2: turnLeft();
                    break;
            case 3: moveForward();
                    break;
            default:
                    System.out.println("Out of bounds error");
                    break;
        }
    }


    // Will be populated with non-basic actions (explore, eat food, etc. )
    public void doRandom(int count) {
        int min = 1;
        int max = 3;
        int rand;
        for(int i = 0; i < count; i++) {
            rand = ThreadLocalRandom.current().nextInt(min, max + 1);
            switch (rand) {
                case 1:
                    turnRight();
                    break;
                case 2:
                    turnLeft();
                    break;
                case 3:
                    moveForward();
                    break;
                default:
                    System.out.println("Out of bounds error");
                    break;
            }
        }
    }

    public String generateRandomName() {
         RandomAccessFile file = null;
        try {
            file = new RandomAccessFile("SurvAIval/src/possibleNames.txt", "r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return getRandomString(file);
    }

    public String generateRandomThought() {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile("SurvAIval/src/possibleThoughts.txt", "r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return getRandomString(file);
    }

    private String getRandomString(RandomAccessFile file) {
        String string = "";
        try {
            long rand = (long) (Math.random() * file.length());
            file.seek(rand);
            file.readLine();
            string = file.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }


    @Override
    public String toString() {
        return "\nCritter Info:" +
                "\nName: " + name +
                "\nCoordinates: (" + x +", " + y + ")" +
                "\nDirection:" + direction +
                "\nMoveSpeed:" + moveSpeed +
                "\nCurrentPath: " + currentPath;
    }
}
