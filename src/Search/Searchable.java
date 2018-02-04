package Search;

import java.util.List;

/**
 * Created by Mandy Cho :) on 2/2/18.
 */
interface Searchable {
    void findPath();
    boolean isGoalState(String arrangement);
    List<String> getSuccessors(String arrangement);
    void devisePath(String arrangement);
}
