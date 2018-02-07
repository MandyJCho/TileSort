package Search.Algorithms.Best;

import Search.Algorithms.Search;
import Search.Node;
import Search.Type;

import java.util.PriorityQueue;

/**
 * Created by Mandy Cho :) on 2/2/18.
 */
public abstract class BestFirstSearch extends Search {
    PriorityQueue<Node> priorityQueue;

    public BestFirstSearch(Type type, boolean includeCost, Node start) {
        super(type, includeCost);
        priorityQueue = new PriorityQueue<>((a, b) -> (a.getCost() == b.getCost()) ? a.discovery - b.discovery
                                                : a.getCost() - b.getCost());
        priorityQueue.offer(start);
    }

    @Override
    public boolean isEmpty() { return priorityQueue.isEmpty(); }

    public Node getNextNode() {
        return priorityQueue.poll();
    }
}
