package Search.Algorithms;

import Search.*;

import java.util.*;

/**
 * Created by Mandy Cho :) on 1/24/18.
 */
public class BFSearchController extends Search {
    private Queue<Node> queue;

    public BFSearchController(Type type, String startArrangement, boolean includeCost) {
        super(type, startArrangement, includeCost);
        Node node = new Node.Builder(startArrangement, null, 0).build();
        queue = new LinkedList<>();
        processSuccessors(node);
    }

    public boolean isEmpty() { return queue.isEmpty(); }

    public Node getNextNode() { return queue.poll(); }

    public void processSuccessors(Node node) {
        // add unique successors
        for (String successor : getSuccessors(node.arrangement)) {
            if (!found.contains(successor))
                queue.offer(new Node.Builder(successor, node, time++).build());
        }
    }

}


