package Search;

/**
 * Created by Mandy Cho :) on 1/24/18.
 */
public abstract class SearchController {
    private char[] tiles;
    // set to keep track of dupplicates

    SearchController(char[] tiles) {
        this.tiles = tiles;
    }

    // search
    abstract void findPath();

    // goal test
    boolean isGoalState() {
        boolean didFindX = false;

        for (char tile : tiles)
            if(tile == 'B' && didFindX) return false;

        return true;
    }

}
