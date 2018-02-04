package Search;

/**
 * Created by Mandy Cho :) on 2/3/18.
 */
interface BestFirstSearchable extends Searchable {
    int h();
    int g();
    void processSuccessors(BestFirstSearch.Node node);
}
