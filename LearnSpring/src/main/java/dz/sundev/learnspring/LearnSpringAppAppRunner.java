package dz.sundev.learnspring;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

//@SpringBootApplication
public class LearnSpringAppAppRunner implements ApplicationRunner {

    /*public static void main(String[] args) {
        SpringApplication.run(LearnSpringAppAppRunner.class, args);
    }*/

    /**
     * execute this function imediately after launching spring
     * @param args
     * @throws Exception
     */

    /** when implements ApplicationRunner */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Sun executes this function after executing spring boot");

    }

    /** when implements CommandLineRunner */
    /*@Override
    public void run(String... args) throws Exception {
        System.out.println("Sun executes this function after executing spring boot");
    }*/
}
