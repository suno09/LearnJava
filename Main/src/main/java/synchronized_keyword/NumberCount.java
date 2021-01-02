package synchronized_keyword;

public class NumberCount {
    private int n;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public NumberCount(int n) {
        this.n = n;
    }

    public void increment() {
        n++;
    }
}
