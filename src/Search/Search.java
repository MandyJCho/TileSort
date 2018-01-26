package Search;

import java.util.*;

/**
 * Created by Mandy Cho :) on 1/24/18.
 */
public interface SearchController {
    HashMap<String, String> foundArrangements;

    // set to keep track of duplicates

    SearchController(String startArrangement) {
        this.startArrangement = startArrangement;
        foundArrangements = new HashMap<>();
        foundArrangements.put(startArrangement, null);
    }

    // search
    abstract void findPath();

    // goal test
    boolean isGoalState(char[] tileArrangement) {
        boolean didFindX = false;

        for (char tile : tileArrangement)
            if(tile == 'B' && didFindX) return false;
            else if (tile == 'x') didFindX = true;

        return true;
    }

    List<String> addSuccessors(final String arrangement) {
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

}
