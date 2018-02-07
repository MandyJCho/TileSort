package Search.BestFirst;

/**
 * Created by Mandy Cho :) on 2/3/18.
 */
interface BestFirstSearchable extends Search.Searchable {
    int h(String arrangement);
    void printMove(Node node);
    void processSuccessors(Node node);
}
