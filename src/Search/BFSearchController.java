package Search;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by Mandy Cho :) on 1/24/18.
 */
public class BFSearchController implements Search {
    SearchHelper.Type type;
    String startArrangement;
    Queue<Pair<String, Integer>> queue;

    BFSearchController(String startArrangement, SearchHelper.Type type) {
        this.startArrangement = startArrangement;
        this.type = type;
        foundArrangements.put(startArrangement, null);
        queue = new LinkedList<>();
        queue.addAll(SearchHelper.addSuccessors(
                new Pair(startArrangement, startArrangement.indexOf('X')),
                foundArrangements)
        );
    }

    public void findPath() {
        System.out.println(startArrangement);
        while (!queue.isEmpty()) {
            Pair<String, Integer> tile = queue.poll();
            String arrangement = tile.getKey();

            // Print
            System.out.println("Move " + tile.getValue() + " " + arrangement);

            // Goal test
            if (SearchHelper.isGoalState(arrangement)) {
                SearchHelper.devisePath(foundArrangements, type, arrangement);
                break;
            }

            // Get successors
            queue.addAll(SearchHelper.addSuccessors(tile, foundArrangements));
        }
    }
}


