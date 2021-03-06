package Search.Algorithms.Best;

import Search.Node;
import Search.Type;

/**
 * Created by Mandy Cho :) on 2/4/18.
 */
public class GreedySearchController extends BestFirstSearch {
    public GreedySearchController(Type type, String startArrangement, boolean includeCost) {
        super(type, includeCost, new Node.Builder(startArrangement, null, 0).build());
    }

    @Override
    public void processSuccessors(Node node) {
        for(String successor : getSuccessors(node.arrangement))
            if (!found.contains(successor)) {
                Node successorNode = new Node.Builder(successor, node, ++time)
                        .hValue(successor)
                        .build();

                priorityQueue.offer(successorNode);
            }
    }
}
