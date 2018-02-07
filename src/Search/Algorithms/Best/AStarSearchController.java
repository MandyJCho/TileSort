package Search.Algorithms.Best;

import Search.Node;
import Search.Type;

/**
 * Created by Mandy Cho :) on 2/4/18.
 */
public class AStarSearchController extends BestFirstSearch {
    public AStarSearchController(Type type, String startArrangement, boolean includeCost) {
        super(type, startArrangement, includeCost);
        Node startNode = new Node.Builder(startArrangement, null, 0).build();
        processSuccessors(startNode);
    }

    @Override
    public void processSuccessors(Node node) {
        for(String successor : getSuccessors(node.arrangement))
            if (!found.contains(successor)) {
                Node successorNode = new Node.Builder(successor, node, ++time)
                        .gValue(successor, node, includeCost)
                        .hValue(successor)
                        .build();

                priorityQueue.offer(successorNode);
            }
    }

}
