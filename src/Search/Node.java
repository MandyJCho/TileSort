package Search;

/**
 * Created by Mandy Cho :) on 2/4/18.
 */
public class Node {
    public final String arrangement;
    public final Node predecessor;
    public final int discovery;
    public final int gValue;
    private final int hValue;

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

        public Builder gValue(String successor, Node parent, boolean includeCost) {
            if (parent == null || !includeCost) gValue = 0;
            else gValue = Math.abs(successor.indexOf("X") - parent.arrangement.indexOf('X')) + parent.gValue;

            return this;
        }

        public Builder hValue(String arrangement) {
            int b = 0;
            for(char c: arrangement.toCharArray())
                if (c == 'B') b++;

            for(int i = 0; i < b; i++)
                if (arrangement.charAt(i) != 'B') hValue++;

            for (int i = b+1; i < arrangement.length(); i++)
                if (arrangement.charAt(i) != 'W') hValue++;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if (getClass() != obj.getClass()) return false;

        Node node = (Node) obj;
        return node.arrangement.equals(arrangement);
    }

    @Override
    public int hashCode() {
        return arrangement.hashCode();
    }
}
