import java.util.ArrayList;
import java.util.List;

//  Possibly a placeholder for creating the pathfinding

public class Node {

    private int gCost;   // distance from start
    private int hCost;   // distance from end
    private int fCost;   // sum of g and h
    private Node parent;
    private int[] coords;
    private int[] dest;
    private boolean passable;

    public int getgCost() { return gCost; }

    public int gethCost() { return hCost; }

    public int getfCost() { return fCost; }

    public Node(Node parent, int[] coords, int[] dest) {
        this.parent = parent;
        this.coords = coords;
        this.dest = dest;
    }

    Node(int[] coords, int[] dest) {
        this.coords = coords;
        this.dest = dest;
    }

    Node(int[] coords) {
        this.coords = coords;
    }

    Node() { }


    // Currently used for testing pathfinding
    public static void main(String[] args) {

        TileMap tileMap = new TileMap(3,4);

        Node startingPoint = new Node(new int[]{0, 0},new int[]{0,0});

        List<Node> open = new ArrayList<Node>();
        List<Node> closed = new ArrayList<Node>();
        open.add(startingPoint);

        while(!open.isEmpty()) {  // WIP
            Node q = new Node();

            for(int i = 0; i < open.size(); i++) {
                if(open.get(i).getfCost() < q.getfCost()) {
                    q = open.get(i);
                }
            }

            new Node(q, new int[]{q.coords[0] + 1, q.coords[1]}, q.dest);
            new Node(q, new int[]{q.coords[0] - 1, q.coords[1]}, q.dest);
            new Node(q, new int[]{q.coords[0], q.coords[1] + 1}, q.dest);
            new Node(q, new int[]{q.coords[0], q.coords[1] - 1}, q.dest);





        }


    }


}
