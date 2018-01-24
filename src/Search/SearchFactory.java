package Search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mandy Cho :) on 1/24/18.
 */
public class SearchFactory {
    public static enum Type {
        BFS("bfs"),
        DFS("dfs"),
        UCS("ucs"),
        GS("gs"),
        ASTAR("a-star");

        private final String type;
        static private final Map<String, Type> lookup;
        static {
            lookup = new HashMap<>();
            Arrays.stream(Type.values())
                    .forEach((value) -> {
                        lookup.put(value.getType(), value);
                    });
        }

        Type(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public static SearchController getSearchController (Type type, char[] input, String userSelection) {
        Type selectionType = Type.valueOf(userSelection);
        SearchController  searchController;

        // Handle user searchcontroller selection
        switch(selectionType) {
            case BFS:
                searchController = new BFSearchController(input);
                break;
            case DFS:
                searchController = new DFSearchController(input);
                break;
//            case UCS:
//                System.out.println("U");
//                break;
//            case GS:
//                System.out.println("G");
//                break;
//            case ASTAR:
//                System.out.println("A");
//                break;
            default:
                System.out.println("Invalid entry");
                System.exit(0);
        }

        return searchController;
    }
}
