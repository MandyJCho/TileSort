package Search;

import java.util.*;

/**
 * Created by Mandy Cho :) on 1/26/18.
 */
public class SearchHelper {

    static boolean isGoalState(String arrangement) {
        boolean foundX = false, foundW = false;

        for (char tile : arrangement.toCharArray()) {
            foundW = tile == 'W' ? true : foundW;
            foundX = tile == 'x' ? true : foundX;

            if (tile == 'B' && (foundX || foundW)) return false;
            else if (tile == 'W' && !foundX) return false;
        }

        return true;
    }

    static List<String> addSuccessors(final String arrangement, Map<String, String> foundArrangements) {
        final int xIndex = arrangement.indexOf('x');
        List<String> newSuccessors = new ArrayList<>();

        for(int i = 0; i < arrangement.length(); i++) {
            StringBuilder successor = new StringBuilder(arrangement);
            char color = arrangement.charAt(i);
            successor.replace(i, i+1, "x");
            successor.replace(xIndex, xIndex + 1, color+"");

            if (!foundArrangements.containsKey(successor.toString())) newSuccessors.add(successor.toString());
        }

        return newSuccessors;
    }

    static void devisePath(Map<String, String> foundArrangements, SearchFactory.Type type, String arrangement, String startArrangement) {
        Stack<String> path = new Stack<>();
        while (arrangement != null) {

        }
    }
}
