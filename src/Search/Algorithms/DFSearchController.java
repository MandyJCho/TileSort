package Search.Algorithms;

import Search.*;

import java.util.*;

/**
 * Created by Mandy Cho :) on 1/24/18.
 */
public class DFSearchController extends Search {
    private Stack<Node> stack;

    public DFSearchController(Type type, String startArrangement, boolean includeCost) {
        super(type, startArrangement, includeCost);
        Node node = new Node.Builder(startArrangement, null, 0).build();
        stack = new Stack<>();
        processSuccessors(node);
    }

    public boolean isEmpty() { return stack.isEmpty(); }

    public Node getNextNode() { return stack.pop(); }

    public void processSuccessors(Node node) {
        List<String> successors = getSuccessors(node.arrangement);

        for(int i = successors.size() - 1; i >= 0; i--) {
            String successor = successors.get(i);
            if (!found.contains(successor))
                stack.push(new Node.Builder(successor, node, time++).build());
        }
    }
}

