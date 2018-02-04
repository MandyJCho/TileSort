package Search;

import java.util.*;

/**
 * Created by Mandy Cho :) on 1/24/18.
 */
public class DFSearchController extends Search implements BasicSearchable {
    private Stack<String> stack;

    DFSearchController(Type type, String startArrangement) {
        super(type, startArrangement);
        foundArrangements.put(startArrangement, null);
        stack = new Stack<>();
        processSuccessors(startArrangement);
    }

    public void findPath() {
        System.out.println(startArrangement);
        String previous = startArrangement;
        while (!stack.isEmpty()) {
            String arrangement = stack.pop();

            // Mark the visited node
            foundArrangements.put(arrangement, previous);

            // Print
            System.out.println("Move " + arrangement.indexOf("X") + " " + arrangement);

            // Goal test
            if (isGoalState(arrangement)) {
                devisePath(arrangement);
                break;
            }

            // Add successors
            processSuccessors(arrangement);
            previous = arrangement;
        }
    }

    public void processSuccessors(String arrangement) {
        List<String> successors = getSuccessors(arrangement);

        for(int i = successors.size() - 1; i >= 0; i--) {
            String successor = successors.get(i);
            if (!foundArrangements.containsKey(successor))
                stack.push(successor);
        }
    }

}
