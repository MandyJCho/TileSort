//package Search.BestFirst;
//
//import Search.*;
//
//import java.util.PriorityQueue;
//
///**
// * Created by Mandy Cho :) on 2/2/18.
// */
//public abstract class BestFirstSearch extends Search implements BestFirstSearchable {
//    protected PriorityQueue<Node> priorityQueue;
//    int time;
//
//    BestFirstSearch(Type type, String startArrangement, boolean includeCost) {
//        super(type, startArrangement, includeCost);
//        time = 0;
//        priorityQueue = new PriorityQueue<>((a, b) -> (a.getCost() == b.getCost()) ? a.discovery - b.discovery
//                                                : a.getCost() - b.getCost());
//        foundArrangements.put(startArrangement, null);
//    }
//
//    @Override
//    public int h(String arrangement) {
//        int w = 0, count = 0;
//        for (char c: arrangement.toCharArray()) {
//            if (c == 'W') w++;
//            else if (c == 'B' & w > 0) {
//                w--;
//                count +=2;
//            }
//        }
//
//        return count;
//    }
//
//    @Override
//    public void printMove(Node node) {
//        // Print
//        System.out.print("Move " + node.arrangement.indexOf("X") + " " + node.arrangement);
//        if (includeCost) System.out.print(" (c=" + (Math.abs(node.predecessor.indexOf("X") - node.arrangement.indexOf("X"))) + ")");
//        System.out.println();
//    }
//
//
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
//
//}
