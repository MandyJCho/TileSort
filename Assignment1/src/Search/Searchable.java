package Search;

import java.util.List;
import java.util.Stack;

/**
 * Created by Mandy Cho :) on 2/2/18.
 */
public interface Searchable {
    void findPath();
    boolean isGoalState(String arrangement);
    List<String> getSuccessors(String arrangement);
    void printPath(String arrangement);
}
