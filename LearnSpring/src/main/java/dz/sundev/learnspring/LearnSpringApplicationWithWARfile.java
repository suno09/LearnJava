package dz.sundev.learnspring;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

//@SpringBootApplication
@RestController
public class LearnSpringApplicationWithWARfile extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LearnSpringApplicationWithWARfile.class);
    }

    /*public static void main(String[] args) {
        SpringApplication.run(LearnSpringApplicationWithWARfile.class, args);
    }*/
}
