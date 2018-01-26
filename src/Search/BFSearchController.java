package Search;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Mandy Cho :) on 1/24/18.
 */
public class BFSearchController implements Search {
    SearchFactory.Type type;
    String startArrangement;
    Queue<String> queue;
    HashMap<String, String> foundArrangements;

    BFSearchController(String startArrangement, SearchFactory.Type type) {
        this.startArrangement = startArrangement;
        this.type = type;
        queue = new LinkedList<>();
        queue.offer(this.startArrangement);
        foundArrangements.put(startArrangement, null);
    }


    public void findPath() {
        while (!queue.isEmpty() ) {
            String arrangement = queue.poll();
            // Goal test
            if (SearchHelper.isGoalState(arrangement)) {
                SearchHelper.devisePath(arrangement, foundArrangements);
                break;
            }
            // Get successors
            queue.addAll(SearchHelper.addSuccessors(arrangement, foundArrangements));
        }
    }
}


