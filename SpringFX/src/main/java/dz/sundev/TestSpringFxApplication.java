package dz.sundev;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestSpringFxApplication {
    public static void main(String[] args) {
//		SpringApplication.run(TestSpringFxApplication.class, args);
        Application.launch(dz.sundev.JavaFXApplication.class, args);
    }
}
