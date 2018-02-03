package Search;

import java.util.*;

/**
 * Created by Mandy Cho :) on 1/24/18.
 */
public class BFSearchController extends Search {
    private Queue<String> queue;

    BFSearchController(SearchHelper.Type type, String startArrangement) {
        super(type, startArrangement);
        foundArrangements.put(startArrangement, null);
        queue = new LinkedList<>();
        addSuccessors(startArrangement);
    }

    public void findPath() {
        System.out.println(startArrangement);
        while (!queue.isEmpty()) {
            String arrangement = queue.poll();

            // Print
            System.out.println("Move " + arrangement.indexOf("X") + " " + arrangement);

            // Goal test
            if (isGoalState(arrangement)) {
                devisePath(type, arrangement);
                break;
            }

            addSuccessors(arrangement);

        }
    }

    public void addSuccessors(String arrangement) {
        for (String successor : getSuccessors(arrangement)) {
            if (!foundArrangements.containsKey(successor)) {
                foundArrangements.put(successor, arrangement);
                queue.offer(successor);
            }
        }
    }
}


