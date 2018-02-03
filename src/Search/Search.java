package Search;

import java.util.*;

/**
 * Created by Mandy Cho :) on 1/24/18.
 */
public abstract class Search implements Searchable {
    protected SearchHelper.Type type;
    protected String startArrangement;
    Map<String, String> foundArrangements;

    Search(SearchHelper.Type type, String startArrangement) {
        this.type = type;
        this.startArrangement = startArrangement;
        foundArrangements = new HashMap<>();
    }

    public boolean isGoalState(String arrangement) {
        boolean foundX = false, foundW = false;

        for (char tile : arrangement.toCharArray()) {
            foundW = tile == 'W' || foundW;
            foundX = tile == 'X' || foundX;

            if (tile == 'B' && (foundX || foundW)) return false;
            else if (tile == 'W' && !foundX) return false;
        }

        return true;
    }

    public List<String> getSuccessors(String arrangement) {
        List<String> newSuccessors = new ArrayList<>();
        final int xIndex = arrangement.indexOf('X');

        for(int i = 0; i < arrangement.length(); i++) {
            StringBuilder successor = new StringBuilder(arrangement);
            char color = arrangement.charAt(i);
            successor.replace(i, i+1, "X");
            successor.replace(xIndex, xIndex + 1, color+"");
            newSuccessors.add(successor.toString());
        }

        return newSuccessors;
    }

    public void devisePath(String arrangement) {
        Stack<String> pathNodes = new Stack<>();
        pathNodes.push(arrangement);
        String tile;

        System.out.println("\n\nFinal Result for " + type + ":");
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
