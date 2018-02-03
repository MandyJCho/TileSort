package Search;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by Mandy Cho :) on 1/24/18.
 */
public class DFSearchController extends Search {
    private SearchHelper.Type type;
    private Stack<String> stack;
    private String startArrangement;

    DFSearchController(SearchHelper.Type type, String startArrangement) {
        super(type, startArrangement);
//        this.startArrangement = startArrangement;
//        this.type = type;
//        foundArrangements.put(startArrangement, null);
//        stack = new Stack<>();
//        stack.push(startArrangement);
//        //stack.addAll(SearchHelper.addSuccessors( startArrangement, foundArrangements));
    }

    public void findPath() {
//        System.out.println(startArrangement);
//        while (!stack.isEmpty()) {
//            String arrangement = stack.pop();
//
//            // Print
//            System.out.println("Move " + arrangement.indexOf('X') + " " + arrangement);
//
//            // Goal test
//            if (SearchHelper.isGoalState(arrangement)) {
//                SearchHelper.devisePath(foundArrangements, type, arrangement);
//                break;
//            }
//
//            //Get successors
//            List<String> successors = SearchHelper.addSuccessors(arrangement);
//            Collections.reverse(successors);
//            // stop checking for duplicates
//            // maintain a set of strings already found
//            // add all the strings
//            stack.addAll(successors);
//        }
    }

}
