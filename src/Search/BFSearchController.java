package Search;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by Mandy Cho :) on 1/24/18.
 */
public class BFSearchController implements Search {
    SearchFactory.Type type;
    String startArrangement;
    Queue<Pair<String, Integer>> queue;

    BFSearchController(String startArrangement, SearchFactory.Type type) {
        this.startArrangement = startArrangement;
        this.type = type;
        foundArrangements.put(startArrangement, null);
        queue = new LinkedList<>();
        queue.addAll(SearchHelper.addSuccessors(startArrangement, foundArrangements));
    }

    public void findPath() {
        System.out.println(startArrangement);
        while (!queue.isEmpty()) {
            Pair<String, Integer> tileInfo = queue.poll();
            String arrangement = tileInfo.getKey();

            // Print
            System.out.println("Move " + tileInfo.getValue() + " " + arrangement);

            // Goal test
            if (SearchHelper.isGoalState(arrangement)) {
                System.out.println("Did it");
                //SearchHelper.devisePath(foundArrangements, type, arrangement);
                break;
            }

            // Get successors
            queue.addAll(SearchHelper.addSuccessors(arrangement, foundArrangements));
        }
    }
}


