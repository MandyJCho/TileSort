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
        processSuccessors(startNode);
    }

    @Override
    public void findPath(){
        System.out.println(startArrangement);

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            // Mark the visited node
            if (foundArrangements.containsKey(node.arrangement)) continue;
            foundArrangements.put(node.arrangement, node.predecessor);

            // Print
            System.out.print("Move " + node.arrangement.indexOf("X") + " " + node.arrangement + " ");
            if (includeCost) System.out.println("(c="
                                                + Math.abs(node.predecessor.indexOf("X") - node.arrangement.indexOf("X"))
                                                + ")");
            else System.out.println();

            // Goal test
            if (isGoalState(node.arrangement)) {
                devisePath(node.arrangement);
                break;
            }

            // Add successors
            processSuccessors(node);
        }
    }

    @Override
    public void processSuccessors(Node node) {
        int nodeX = node.arrangement.indexOf("X");
        for(String successor : getSuccessors(node.arrangement))
            if (!foundArrangements.containsKey(successor)) {
                int g = includeCost ? Math.abs(successor.indexOf("X") - nodeX) : 0;
                Node successorNode = new Node.Builder(successor, node.arrangement, ++time)
                                             .gValue(g + node.gValue)
                                             .build();

                priorityQueue.offer(successorNode);
            }
    }

}
