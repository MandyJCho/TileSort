package Search;

import java.util.*;

/**
 * Created by Mandy Cho :) on 1/26/18.
 */
public class SearchHelper {
    public enum Type {
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
                  .forEach((value) -> lookup.put(value.getType(), value));
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


}
