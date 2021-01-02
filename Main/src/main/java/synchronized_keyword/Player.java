package synchronized_keyword;

public class Player extends Thread {
    private int idp;
    private final NumberCount count;

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public NumberCount getCount() {
        return count;
    }

    public Player(int idp, NumberCount count) {
        this.idp = idp;
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (count) {
            count.increment();
            System.out.println(idp + " => " + count.getN());
        }
    }
}
