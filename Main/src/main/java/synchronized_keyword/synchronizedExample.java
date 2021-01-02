package synchronized_keyword;

public class synchronizedExample {
    public static void main(String[] args) {
        NumberCount numberCount = new NumberCount(0);

        for (int i = 0; i < 10; i++) {
            System.out.println("\nTest " + i);
            Player a = new Player(1, numberCount);
            Player b = new Player(2, numberCount);
            Player c = new Player(3, numberCount);
            Player d = new Player(4, numberCount);


            try {
                a.start();
                b.start();
                c.start();
                d.start();
                a.join();
                b.join();
                c.join();
                d.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
