package Search.BestFirst;

import Search.Searchable;

/**
 * Created by Mandy Cho :) on 2/3/18.
 */
interface BestFirstSearchable extends Search.Searchable {
    int h(Node node);
    int g(Node node);
    void processSuccessors(Node node);
}
