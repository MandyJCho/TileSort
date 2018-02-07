package Search.Algorithms;

import java.util.*;

import Search.Type;
import Search.Node;

/**
 * Created by Mandy Cho :) on 1/24/18.
 */
public abstract class Search implements Searchable {
    public int time = 0;
    protected Type type;
    protected String startArrangement;
    protected Set<String> found;
    protected boolean includeCost;

    protected Search(Type type, String startArrangement, boolean includeCost) {
        this.type = type;
        this.startArrangement = startArrangement;
        this.includeCost = includeCost;
        found = new HashSet<>();
        found.add(startArrangement);
    }

    public void findPath() {
        System.out.println(startArrangement);
        while (!isEmpty()) {
            Node node = getNextNode();

            if (found.contains(node.arrangement)) continue;
            found.add(node.arrangement);

            String arrangement = node.arrangement;
            System.out.print("Move " + arrangement.indexOf("X") + " " + arrangement);
            if (includeCost) System.out.print(" (c=" + (Math.abs(node.predecessor.arrangement.indexOf("X")
                                                        - node.arrangement.indexOf("X"))) + ")");
            System.out.println();

            if (isGoalState(arrangement)) {
                printPath(node);
                break;
            }

            processSuccessors(node);
        }
    }

    public boolean isGoalState(String arrangement) {
        boolean foundX = false, foundW = false;

        for (char tile : arrangement.toCharArray()) {
            foundW = tile == 'W' || foundW;
            foundX = tile == 'X' || foundX;

            if (tile == 'B' && (foundX || foundW)) return false;
            else if (tile == 'W' && !foundX) return false;
        }

        return true;
    }

    public List<String> getSuccessors(String arrangement) {
        List<String> newSuccessors = new ArrayList<>();
        final int xIndex = arrangement.indexOf('X');

        for(int i = 0; i < arrangement.length(); i++) {
            StringBuilder successor = new StringBuilder(arrangement);
            char color = arrangement.charAt(i);
            successor.replace(i, i+1, "X");
            successor.replace(xIndex, xIndex + 1, color+"");
            newSuccessors.add(successor.toString());
        }

        return newSuccessors;
    }

    public void printPath(Node tile) {
        Stack<String> pathNodes = new Stack<>();
        Node node = tile;

        System.out.println("\n\nFinal Result for " + type + ":");
        while (node != null) {
            pathNodes.push(node.arrangement);
            node = node.predecessor;
        }

        int count = 0;
        String previous = pathNodes.pop();
        System.out.println(previous);

        while (!pathNodes.isEmpty()) {
            String pathNode = pathNodes.pop();
            System.out.print("Step " + count++ + ": move " +  pathNode.indexOf('X') + " " + pathNode);
            if (includeCost) System.out.print(" (c=" + Math.abs(previous.indexOf("X") - pathNode.indexOf("X")) + ")");
            System.out.println();
            previous = pathNode;
        }
    }

    @Override
    public int h(Node node) {
        return 0;
    }
}
