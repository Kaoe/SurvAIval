import java.util.concurrent.ThreadLocalRandom;

//import static java.lang.Math.abs;

public class Critter {

    private int direction;
    private int moveSpeed;
    private int[] coords;

    public Critter(int direction, int moveSpeed, int[] coords) {
        this.direction = direction;
        this.moveSpeed = moveSpeed;
        this.coords = coords;
    }

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

    public int[] getCoords() { return coords; }

    public void turnRight() {
        this.direction += 1;
        this.direction %= 4;
        System.out.println("Turning right...");
    }

    public void turnLeft() {
        this.direction += 3;
        this.direction %= 4;
        System.out.println("Turning left...");
    }

    public void moveForward() {
        if(direction == 0) {
            this.coords[1] += 1;
        }else if(direction == 1) {
            this.coords[0] +=1;
        }else if(direction == 2) {
            this.coords[1] -= 1;
        }else if(direction == 3) {
            this.coords[0] -= 1;
        }
        System.out.println("Moving forward...");
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

//    public void pathfind(int x, int y, TileMap tileMap) {
////        int optimalPath = abs(x - this.x) + abs(y - this.y);
//        int a = this.coords[0];
//        int b = this.coords[1];
//
//        while(a != x && b != y) {
//            if((a < x) && tileMap.search(x + 1,y).isPassable()) {   // if tile (a + 1, b) is passable
//                a++;
//            }else if(tileMap.search(x,y + 1).isPassable()) {   // if tile (a, b + 1) is passable
//                b++;
//            }
//
//        }
//
//    }



}
