public class Plugs {
    int[][] pairs;

    public Plugs() {
        pairs = new int[0][];
    }

    public Plugs(int[][] pairs) {
        this.pairs = pairs;
    }

    public int plugsRun(int plugIn){
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i][0]==plugIn)
                return pairs[i][1];
            else if (pairs[i][1]==plugIn)
                return pairs[i][0];
        }
        return  plugIn;
    }

    public void setPairs(int[][] pairs) {
        this.pairs = pairs;
    }
}
