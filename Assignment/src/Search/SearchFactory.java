package Search;

import Search.Algorithms.BFSearchController;
import Search.Algorithms.Best.AStarSearchController;
import Search.Algorithms.Best.GreedySearchController;
import Search.Algorithms.DFSearchController;
import Search.Algorithms.Search;
import Search.Algorithms.Best.UCSearchController;

/**
 * Created by Mandy Cho :) on 1/24/18.
 */
public class SearchFactory {
    public static Search createController(String startArrangement, String userSelection, boolean includeCost) {
        Type selectionType = Type.fromStringValue(userSelection);
        Search  searchController = null;

        // Handle user selection
        switch(selectionType) {
            case BFS:
                searchController = new BFSearchController(selectionType, startArrangement, includeCost);
                break;
            case DFS:
                searchController = new DFSearchController(selectionType, startArrangement, includeCost);
                break;
            case UCS:
                searchController = new UCSearchController(selectionType, startArrangement, includeCost);
                break;
            case GS:
                searchController = new GreedySearchController(selectionType, startArrangement, includeCost);
                break;
            case ASTAR:
                searchController = new AStarSearchController(selectionType, startArrangement, includeCost);
                break;
            default:
                System.out.println("Invalid entry");
                System.exit(0);
        }

        return searchController;
    }
}
