package Search.BestFirst;

/**
 * Created by Mandy Cho :) on 2/3/18.
 */
interface BestFirstSearchable extends Search.Searchable {
    static int h(Node node) {
        return 0;
    }
    // int g(Node prev);
    void processSuccessors(Node node);
}
