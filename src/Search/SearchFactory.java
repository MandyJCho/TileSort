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

        public static Type fromStringValue(String value) {
            return lookup.getOrDefault(value, null);
        }
    }

    public static SearchController getSearchController (char[] input, String userSelection) {
        Type selectionType = Type.fromStringValue(userSelection);
        SearchController  searchController = null;

        // Handle user selection
        switch(selectionType) {
            case BFS:
                System.out.println("b");
                searchController = new BFSearchController(input);
                break;
            case DFS:
                System.out.println("d");
                searchController = new DFSearchController(input);
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
