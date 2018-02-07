package Search;

import java.util.List;
import java.util.Stack;

/**
 * Created by Mandy Cho :) on 2/2/18.
 */
public interface Searchable {
    List<String> getSuccessors(String arrangement);
    Node getNextNode();
    boolean isEmpty();
    boolean isGoalState(String arrangement);
    void findPath();
    void printPath(Node tile);
    void processSuccessors(Node node);
}
