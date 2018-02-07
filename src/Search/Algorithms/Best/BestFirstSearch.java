package Search.Algorithms.Best;

import Search.*;
import Search.Algorithms.Search;

import java.util.PriorityQueue;

/**
 * Created by Mandy Cho :) on 2/2/18.
 */
public abstract class BestFirstSearch extends Search {
    PriorityQueue<Node> priorityQueue;

    public BestFirstSearch(Type type, String startArrangement, boolean includeCost) {
        super(type, startArrangement, includeCost);
        priorityQueue = new PriorityQueue<>((a, b) -> (a.getCost() == b.getCost()) ? a.discovery - b.discovery
                                                : a.getCost() - b.getCost());
    }

    int g(String successor, Node parent) {
        return includeCost ? Math.abs(successor.indexOf("X") - parent.arrangement.indexOf('X')) + parent.gValue: 0;
    }

    int h(String arrangement) {
        int w = 0, count = 0;
        for (char c: arrangement.toCharArray()) {
            if (c == 'W') w++;
            else if (c == 'B' & w > 0) {
                w--;
                count +=2;
            }
        }

        return count;
    }

    @Override
    public boolean isEmpty() { return priorityQueue.isEmpty(); }

    public Node getNextNode() {
        return priorityQueue.poll();
    }
}
