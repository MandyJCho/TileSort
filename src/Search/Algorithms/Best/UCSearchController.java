package Search.Algorithms.Best;

import Search.Node;
import Search.Type;

/**
 * Created by Mandy Cho :) on 2/4/18.
 */
public class UCSearchController extends BestFirstSearch {
    public UCSearchController(Type type, String startArrangement, boolean includeCost) {
        super(type, startArrangement, includeCost);

        Node node = new Node.Builder(startArrangement, null, 0).build();
        processSuccessors(node);
    }

    @Override
    public void processSuccessors(Node node) {
        for(String successor : getSuccessors(node.arrangement))
            if (!found.contains(successor)) {
                Node successorNode = new Node.Builder(successor, node, ++time)
                                             .gValue(successor, node, includeCost)
                                             .build();

                priorityQueue.offer(successorNode);
            }
    }

}
