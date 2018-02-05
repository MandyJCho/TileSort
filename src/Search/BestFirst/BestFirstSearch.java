package Search.BestFirst;

import Search.*;

import java.util.PriorityQueue;

/**
 * Created by Mandy Cho :) on 2/2/18.
 */
public abstract class BestFirstSearch extends Search implements BestFirstSearchable {
    protected PriorityQueue<Node> priorityQueue;
    int time;

    BestFirstSearch(Type type, String startArrangement, boolean includeCost) {
        super(type, startArrangement, includeCost);
        time = 0;
        priorityQueue = new PriorityQueue<>((a, b) -> (a.getCost() == b.getCost()) ? a.discovery - b.discovery
                                                : a.getCost() - b.getCost());
        foundArrangements.put(startArrangement, null);
    }

    @Override
    public int h(String arrangement) {
        int black = 0;
        for(char c : arrangement.toCharArray())
            if (c == 'B') black++;

        int i = 0, count = arrangement.charAt(black) == 'X' ? 0 : 1;

        while(i < black)
            if (arrangement.charAt(i++) != 'B') count++;
        while (++i < arrangement.length())
            if (arrangement.charAt(i) != 'W') count++;

        return count;
    }

    @Override
    public void printMove(Node node) {
        // Print
        System.out.print("Move " + node.arrangement.indexOf("X") + " " + node.arrangement);
        if (includeCost) System.out.print(" (c=" + (Math.abs(node.predecessor.indexOf("X") - node.arrangement.indexOf("X"))) + ")");
        System.out.println();
    }


    @Override
    public void findPath(){
        System.out.println(startArrangement);

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            // Mark the visited node
            if (foundArrangements.containsKey(node.arrangement)) continue;
            foundArrangements.put(node.arrangement, node.predecessor);

            // Print
            printMove(node);

            // Goal test
            if (isGoalState(node.arrangement)) {
                printPath(node.arrangement);
                break;
            }

            // Add successors
            processSuccessors(node);
        }
    }

    /**
     A∗ implies sorting the queue according to the evaluation function f, where f = g + h.)

     For GS, assume that h(n) = number of tiles out of place (e.g., in the 3-position example we
     started with 2 out-of-place tiles)
     For A∗, estimate the total path cost as f(n) = g(n) + h(n) where g and h are defined as above
     */
}
