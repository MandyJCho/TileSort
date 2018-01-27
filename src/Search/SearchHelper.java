package Search;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by Mandy Cho :) on 1/26/18.
 */
public class SearchHelper {

    public static boolean isGoalState(String arrangement) {
        boolean foundX = false, foundW = false;

        for (char tile : arrangement.toCharArray()) {
            foundW = tile == 'W' ? true : foundW;
            foundX = tile == 'x' ? true : foundX;

            if (tile == 'B' && (foundX || foundW)) return false;
            else if (tile == 'W' && !foundX) return false;
        }

        return true;
    }

    public static List<Pair<String, Integer>> addSuccessors(final String arrangement, Map<String, String> foundArrangements) {
        final int xIndex = arrangement.indexOf('x');
        List<Pair<String, Integer>> newSuccessors = new ArrayList<Pair<String, Integer>>();

        for(int i = 0; i < arrangement.length(); i++) {
            StringBuilder successor = new StringBuilder(arrangement);
            char color = arrangement.charAt(i);
            successor.replace(i, i+1, "x");
            successor.replace(xIndex, xIndex + 1, color+"");

            String successorKey = successor.toString();
            if (!foundArrangements.containsKey(successorKey)) {
                newSuccessors.add(new Pair(successorKey, i));
                foundArrangements.put(successorKey, arrangement);
            }
        }

        return newSuccessors;
    }

    public static void devisePath(Map<String, String> foundArrangements, SearchFactory.Type type, String arrangement) {
        Stack<String> path = new Stack<>();
        while (arrangement != null) {

        }
    }
}
