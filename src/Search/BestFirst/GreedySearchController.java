package Search.BestFirst;

import Search.Type;

/**
 * Created by Mandy Cho :) on 2/4/18.
 */
public class GreedySearchController extends BestFirstSearch {
    public GreedySearchController(Type type, String startArrangement, boolean includeCost) {
        super(type, startArrangement, includeCost);
        Node startNode = new Node.Builder(startArrangement, null, 0)
                .hValue(h(startArrangement))
                .build();

        processSuccessors(startNode);
    }

    @Override
    public void printMove(Node node) {
        System.out.print("Move " + node.arrangement.indexOf("X") + " " + node.arrangement + " ");
        if (includeCost) System.out.print("(c="
                + h(node.arrangement)
                + ")");
        System.out.println();
    }

    @Override
    public void processSuccessors(Node node) {
        for(String successor : getSuccessors(node.arrangement))
            if (!foundArrangements.containsKey(successor)) {
                Node successorNode = new Node.Builder(successor, node.arrangement, ++time)
                        .hValue(h(node.arrangement))
                        .build();

                priorityQueue.offer(successorNode);
            }
    }

}
