package Search;

/**
 * Created by Mandy Cho :) on 2/4/18.
 */
public class Node {
    final String arrangement;
    final Node predecessor;
    int discovery;
    int gValue;
    int hValue;

    public static class Builder {
        private String arrangement;
        private Node predecessor;
        private int discovery;
        private int gValue = 0;
        private int hValue = 0;

        public Builder(String arrangement, Node predecessor, int discovery) {
            this.arrangement = arrangement;
            this.predecessor = predecessor;
            this.discovery = discovery;
        }

        public Builder gValue(int gValue) {
            this.gValue = gValue;
            return this;
        }

        public Builder hValue(int hValue) {
            this.hValue = hValue;
            return this;
        }

        public Node build() {
            return new Node(this);
        }

    }

    protected Node(Builder builder) {
        this.arrangement = builder.arrangement;
        this.predecessor = builder.predecessor;
        this.discovery = builder.discovery;
        this.gValue = builder.gValue;
        this.hValue = builder.hValue;
    }

    public int getCost() {
        return gValue + hValue;
    }

    public String getArrangement() { return arrangement; }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        return ((Node) obj).arrangement.equals(arrangement);
    }

    @Override
    public int hashCode() {
        return arrangement.hashCode();
    }
}
