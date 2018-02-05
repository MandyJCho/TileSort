package Search.BestFirst;

import Search.Type;

/**
 * Created by Mandy Cho :) on 2/4/18.
 */
public class AStarSearchController extends BestFirstSearch {
    public AStarSearchController(Type type, String startArrangement, boolean includeCost) {
        super(type, startArrangement, includeCost);
        Node startNode = new Node.Builder(startArrangement, null, 0)
                .gValue(0)
                .hValue(h(startArrangement))
                .build();
        processSuccessors(startNode);
    }

//    @Override
//    public void findPath(){
//        System.out.println(startArrangement);
//
//        while (!priorityQueue.isEmpty()) {
//            Node node = priorityQueue.poll();
//
//            // Mark the visited node
//            if (foundArrangements.containsKey(node.arrangement)) continue;
//            foundArrangements.put(node.arrangement, node.predecessor);
//
//            // Print
//            printMove(node);
//
//            // Goal test
//            if (isGoalState(node.arrangement)) {
//                printPath(node.arrangement);
//                break;
//            }
//
//            // Add successors
//            processSuccessors(node);
//        }
//    }

    @Override
    public void processSuccessors(Node node) {
        int nodeX = node.arrangement.indexOf("X");
        for(String successor : getSuccessors(node.arrangement))
            if (!foundArrangements.containsKey(successor)) {
                int g = node.gValue + (includeCost ? Math.abs(successor.indexOf("X") - nodeX) : 0);
                int h = h(successor);
                h = h + g < node.getCost() ? node.getCost() - g : h;
                Node successorNode = new Node.Builder(successor, node.arrangement, ++time)
                        .gValue(g)
                        .hValue(h)
                        .build();

                priorityQueue.offer(successorNode);
            }
    }

}
