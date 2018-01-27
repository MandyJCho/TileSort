package Search;

import javafx.util.Pair;

import java.security.PrivateKey;
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

    public static boolean isGoalState(String arrangement) {
        boolean foundX = false, foundW = false;

        for (char tile : arrangement.toCharArray()) {
            foundW = tile == 'W' ? true : foundW;
            foundX = tile == 'X' ? true : foundX;

            if (tile == 'B' && (foundX || foundW)) return false;
            else if (tile == 'W' && !foundX) return false;
        }

        return true;
    }

    public static List<Pair<String, Integer>> addSuccessors(Pair<String, Integer> tile,
                                                            Map<String, String> foundArrangements) {
        List<Pair<String, Integer>> newSuccessors = new ArrayList<>();
        final int xIndex = tile.getValue();
        final String arrangement = tile.getKey();

        for(int i = 0; i < arrangement.length(); i++) {
            StringBuilder successor = new StringBuilder(arrangement);
            char color = arrangement.charAt(i);
            successor.replace(i, i+1, "X");
            successor.replace(xIndex, xIndex + 1, color+"");

            String successorKey = successor.toString();
            if (!foundArrangements.containsKey(successorKey)) {
                newSuccessors.add(new Pair(successorKey, i));
                foundArrangements.put(successorKey, arrangement);
            }
        }

        return newSuccessors;
    }

    public static void devisePath(Map<String, String> foundArrangements, Type type, String arrangement) {
        Stack<String> pathNodes = new Stack<>();
        pathNodes.push(arrangement);
        String tile;

        System.out.println("\nFinal result for " + type);
        while ((tile = foundArrangements.getOrDefault(arrangement, null)) != null) {
            pathNodes.push(tile);
            arrangement = foundArrangements.get(arrangement);
        }

        int count = 0;
        System.out.println(pathNodes.pop());
        while (!pathNodes.isEmpty()) {
            String node = pathNodes.pop();
            System.out.println("Step " + count++ + ": move " +  node.indexOf('X') + " " + node);
        }
    }
}
