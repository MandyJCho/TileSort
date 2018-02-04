package Search.BestFirst;

import Search.*;

/**
 * Created by Mandy Cho :) on 2/4/18.
 */
public class UCSearchController extends BestFirstSearch {
    public UCSearchController(Type type, String startArrangement, boolean includeCost) {
        super(type, startArrangement, includeCost);
        Node startNode = new Node.Builder(startArrangement, null, 0)
                                 .gValue(0)
                                 .build();
        setStartNode(startNode);
        foundArrangements.put(startArrangement, null);
    }

    @Override
    public void findPath(){

    }

    @Override
    public void processSuccessors(Node node) {
        for(String successor : getSuccessors(node.arrangement))
            if (!foundArrangements.containsKey(successor)) {

            }
    }
}
