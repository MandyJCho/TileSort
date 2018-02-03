package Search;

/**
 * Created by Mandy Cho :) on 1/24/18.
 */
public class SearchFactory {
    public static Search getSearchController (String startArrangement, String userSelection) {
        SearchHelper.Type selectionType = SearchHelper.Type.fromStringValue(userSelection);
        Search  searchController = null;

        // Handle user selection
        switch(selectionType) {
            case BFS:
                searchController = new BFSearchController(selectionType, startArrangement);
                break;
            case DFS:
                searchController = new DFSearchController(selectionType, startArrangement);
                break;
            case UCS:
                System.out.println("U");
                break;
            case GS:
                System.out.println("G");
                break;
            case ASTAR:
                System.out.println("A");
                break;
            default:
                System.out.println("Invalid entry");
                System.exit(0);
        }

        return searchController;
    }
}
