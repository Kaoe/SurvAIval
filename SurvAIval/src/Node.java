import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.StrictMath.*;

public class Node {

    private int gCost;   // distance from start
    private int hCost;   // distance from end
    private int fCost;   // sum of g and h
    private Node parent;
    private int xCoord;
    private int yCoord;
    private int xDest;
    private int yDest;

    public Node(int xCoord, int yCoord, int xDest, int yDest) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.xDest = xDest;
        this.yDest = yDest;
    }

    public Node(Node parent, int xCoord, int yCoord, int xDest, int yDest) {
        this.parent = parent;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.xDest = xDest;
        this.yDest = yDest;
    }

    static int calculateHCost(Node node) {
        return abs(node.xCoord-node.xDest) + abs(node.yCoord-node.yDest);
    }

    boolean isValid(TileMap tileMap) {
        return tileMap.isValid(this.xCoord, this.yCoord);
    }

    private boolean isPassable(TileMap tileMap) {
        return tileMap.isPassable(this.xCoord, this.yCoord);
    }

    @Override
    public String toString() {
        return "Node{" +
                "gCost=" + gCost +
                ", hCost=" + hCost +
                ", fCost=" + fCost +
                ", parent=" + parent +
                ", xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                ", xDest=" + xDest +
                ", yDest=" + yDest +
                '}';
    }

    public static List pathfind(TileMap tileMap, int xCoord, int yCoord, int xDest, int yDest) {

        if (!tileMap.isPassable(xDest, yDest)) {
            return null;
        }

        Node startingPoint = new Node(xCoord,yCoord,xDest,yDest);

        // open is a list of nodes being checked
        // closed is a list of nodes that have already been checked
        List<Node> open = new ArrayList<>();
        List<Node> closed = new ArrayList<>();

        Node current = startingPoint;
        current.hCost = calculateHCost(current);
        current.fCost = current.hCost;
        open.add(current);

        while(!open.isEmpty()) {

            //  Finding node with the lowest fCost
            for (Node node : open) {
                if (node.fCost < current.fCost) {
                    current = node;
                } else if (node.fCost == current.fCost && node.hCost < current.hCost) {
                    current = node;
                }
            }
            open.remove(current);
            closed.add(current);

            //  If destination is found...
            if(current.xCoord == current.xDest && current.yCoord == current.yDest) {

                //  Creating a list of directions to take from starting point
                Node node = current;
                int i = 0;
                List directions = new ArrayList();
                while(node.parent != null) {
                    if (node.parent.yCoord < node.yCoord) {
                        directions.add(0);
                    }else if (node.parent.xCoord < node.xCoord) {
                        directions.add(1);
                    }else if (node.parent.yCoord > node.yCoord) {
                        directions.add(2);
                    }else if (node.parent.xCoord > node.xCoord) {
                        directions.add(3);
                    }
                    node = node.parent;
                }
                Collections.reverse(directions);
                return directions;
            }

            //  Generating new nodes
            List<Node> newNodes = new ArrayList<>();
            newNodes.add(new Node(current, current.xCoord + 1, current.yCoord, current.xDest, current.yDest));
            newNodes.add(new Node(current, current.xCoord - 1, current.yCoord, current.xDest, current.yDest));
            newNodes.add(new Node(current, current.xCoord, current.yCoord + 1, current.xDest, current.yDest));
            newNodes.add(new Node(current, current.xCoord, current.yCoord - 1, current.xDest, current.yDest));

            //  Removing nodes that are out of bounds (invalid), not passable, or are in the closed list
            for(int i = 0; i < newNodes.size(); i++) {
                if (closed.contains(newNodes.get(i)) || !newNodes.get(i).isValid(tileMap) || !newNodes.get(i).isPassable(tileMap)) {
                    newNodes.remove(newNodes.get(i));
                    i--;
                }
            }

            //  Checking remaining nodes
            for (Node newNode : newNodes) {

                //  Calculating costs
                int gNew = current.gCost + 1;
                int hNew = calculateHCost(newNode);
                int fNew = gNew + hNew;

                //  If new node is not in open or if new node is more efficient than current node...
                if (!open.contains(newNode) || fNew < current.fCost) {  // Add check to see if current f-value is better than previous f-value
                    newNode.gCost = gNew;
                    newNode.hCost = hNew;
                    newNode.fCost = fNew;
                    newNode.parent = current;
                    if (!open.contains(newNode)) {
                        open.add(newNode);
                    }
                }
            }
        }
        return null;
    }
}
