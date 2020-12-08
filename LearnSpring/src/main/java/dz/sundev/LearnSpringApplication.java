package dz.sundev;

import dz.sundev.vos.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling // this for enable executing the tasks for the specific time period
@RestController
public class LearnSpringApplication {
	@Autowired
	HelloMessage helloMessage;

	@Value("${spring.application.name}") // get the value in properties file
	private String appName;

	@Value("${chemsou_key:default_value_if_nexist}") // get the value in properties file
	private String appNameWithDefaultValue;

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringApplication.class, args);
	}

	@RequestMapping(value = "/index")
	public String hello() {
		helloMessage.setMsg(appName + " == " + appNameWithDefaultValue);
		return helloMessage.toString();
	}

	@Bean
	public HelloMessage getHelloMessage() {
		return new HelloMessage();
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	/** Configure for problem "no 'access-control-allow-origin' header is present on the requested resource. angular spring boot" */
	/*@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Collections.singletonList("*"));
		config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}*/
	/** Enable cors  */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/products").allowedOrigins("http://localhost:8080");
			}
		};
	}

	/** create and delete storage *//*
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}*/

	/*@Bean
	public CommandLineRunner demo (UserRepositoryWithJpa userRepository, BookRepository bookRepository) {
		return (args) -> {
			Book book1 = bookRepository.saveAndFlush(new Book("book1"));
			Book book2 = bookRepository.saveAndFlush(new Book("book2"));
			Book book3 = bookRepository.saveAndFlush(new Book("book3"));

			Stream.of(book1, book2, book3).forEach(System.out::println);
			// save a few customers
			userRepository.saveAndFlush(new User("Jack", "Bauer", Stream.of(book1, book2).collect(Collectors.toSet())));
			userRepository.saveAndFlush(new User("Chloe", "O'Brian", Stream.of(book1, book2).collect(Collectors.toSet())));
			userRepository.saveAndFlush(new User("Kim", "Bauer", Stream.of(book1, book3, book2).collect(Collectors.toSet())));
			userRepository.saveAndFlush(new User("David", "Palmer", Stream.of(book3, book2).collect(Collectors.toSet())));
			userRepository.saveAndFlush(new User("Michelle", "Dessler", Stream.of(book1, book2).collect(Collectors.toSet())));
		};
	}*/
}
