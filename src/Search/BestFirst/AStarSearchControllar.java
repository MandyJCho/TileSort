package Search.BestFirst;

import Search.Type;

/**
 * Created by Mandy Cho :) on 2/4/18.
 */
public class AStarSearchControllar extends BestFirstSearch {
    public AStarSearchControllar(Type type, String startArrangement, boolean includeCost) {
        super(type, startArrangement, includeCost);
        Node startNode = new Node.Builder(startArrangement, null, 0)
                .gValue(0)
                .hValue(h(startArrangement))
                .build();
        processSuccessors(startNode);
    }

    @Override
    public void processSuccessors(Node node) {
        int nodeX = node.arrangement.indexOf("X");
        for(String successor : getSuccessors(node.arrangement))
            if (!foundArrangements.containsKey(successor)) {
                int g = includeCost ? Math.abs(successor.indexOf("X") - nodeX) : 0;
                Node successorNode = new Node.Builder(successor, node.arrangement, ++time)
                        .gValue(g + node.gValue)
                        .hValue(h(successor))
                        .build();

                priorityQueue.offer(successorNode);
            }
    }

}
