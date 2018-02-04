package Search.BestFirst;

import Search.Search;

import java.util.PriorityQueue;

/**
 * Created by Mandy Cho :) on 2/2/18.
 */
public abstract class BestFirstSearch extends Search implements BestFirstSearchable {
    protected PriorityQueue<Node> priorityQueue;
    protected boolean includeCost;
    protected Node startNode;
    int time;

    BestFirstSearch(Search.Type type, String startArrangement, boolean includesCost) {
        super(type, startArrangement);

        this.startNode = startNode;
        time = 0;
        priorityQueue = new PriorityQueue<>((a, b) -> {
            if (a.getCost() == b.getCost()) return b.discovery - a.discovery ;
            else return a.getCost() - b.getCost();
        });
    }

    protected void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    public int h() {
        return 0;
    }

    public int g(Node node) {
        if (includeCost) {
            node.gValue++;
        }

        return 0;
    }

    /**
     UCS implies sorting the queue according to
     the g function, GS implies sorting the queue according to the h function, and A∗
     implies sorting the queue according to the evaluation function f, where f = g + h.) If two or more nodes in your
     data structure have the same f cost, break ties using a FIFO strategy (i.e., prefer nodes that have
     been in the data structure for the longest time). Also, note that you will need a means of avoiding
     loops by checking whether or not a state has already been visited. You should not expand a state
     that has previously been expanded.
     For UCS, assume that g(n) = number of moves executed so far
     For GS, assume that h(n) = number of tiles out of place (e.g., in the 3-position example we
     started with 2 out-of-place tiles)
     For A∗, estimate the total path cost as f(n) = g(n) + h(n) where g and h are defined as above


     ////
     PriorityQueue of the <String, Number of strings>
     regards for age since number of moves isn't the same, hash the strings by discovery time
     flag for costs


     1. Set L to be the initial node(s) representing the initial
     state(s).
     2. If L is empty, fail. Let n be the node on L that is “most
     promising” according to f. Remove n from L.
     3. If n is a goal node, stop and return it (and the path
     from the initial node to n).
     4. Otherwise, add successors(n) to L. Return to step 2.
     */

}