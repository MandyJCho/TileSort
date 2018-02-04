package Search;

import java.util.*;

/**
 * Created by Mandy Cho :) on 1/24/18.
 */
public class BFSearchController extends Search implements BasicSearchable {
    private Queue<String> queue;

    BFSearchController(Type type, String startArrangement) {
        super(type, startArrangement);
        foundArrangements.put(startArrangement, null);
        queue = new LinkedList<>();
        processSuccessors(startArrangement);
    }

    public void findPath() {
        System.out.println(startArrangement);
        while (!queue.isEmpty()) {
            String arrangement = queue.poll();

            // Print
            System.out.println("Move " + arrangement.indexOf("X") + " " + arrangement);

            // Goal test
            if (isGoalState(arrangement)) {
                devisePath(arrangement);
                break;
            }

            // Add successors
            processSuccessors(arrangement);
        }
    }

    public void processSuccessors(String arrangement) {
        for (String successor : getSuccessors(arrangement)) {
            if (!foundArrangements.containsKey(successor)) {
                foundArrangements.put(successor, arrangement);
                queue.offer(successor);
            }
        }
    }

}


