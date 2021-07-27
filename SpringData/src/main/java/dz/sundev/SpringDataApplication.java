package dz.sundev;

import dz.sundev.db.cascade_persist.Address_;
import dz.sundev.db.cascade_persist.Address_Repository;
import dz.sundev.db.cascade_persist.Person_;
import dz.sundev.db.cascade_persist.Person_Repository;
import dz.sundev.db.onetomany.Book;
import dz.sundev.db.onetomany.BookRepository;
import dz.sundev.db.onetomany.Page;
import dz.sundev.db.onetomany.PageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SpringDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner demo (UserRepository userRepository, BookRepository bookRepository) {
		return (args) -> {
			Book book1 = bookRepository.saveAndFlush(new Book("book1", AuthorStatus.GOOD, LocalDateTime.now()));
			Book book2 = bookRepository.saveAndFlush(new Book("book2", AuthorStatus.BAD, LocalDateTime.now()));
			Book book3 = bookRepository.saveAndFlush(new Book("book3", AuthorStatus.GOOD, LocalDateTime.now()));

			Stream.of(book1, book2, book3).forEach(System.out::println);
			// save a few customers
			userRepository.saveAndFlush(new User("Jack", "Bauer", Stream.of(book1, book2).collect(Collectors.toSet())));
			userRepository.saveAndFlush(new User("Chloe", "O'Brian", Stream.of(book1, book2).collect(Collectors.toSet())));
			userRepository.saveAndFlush(new User("Kim", "Bauer", Stream.of(book1, book3, book2).collect(Collectors.toSet())));
			userRepository.saveAndFlush(new User("David", "Palmer", Stream.of(book3, book2).collect(Collectors.toSet())));
			userRepository.saveAndFlush(new User("Michelle", "Dessler", Stream.of(book1, book2).collect(Collectors.toSet())));
		};
	}*/

	/*@Bean
	public CommandLineRunner mappingDemo(StudentRepository studentRepository,
										 CourseRepository courseRepository) {
		return args -> {

			// create a student
			Student student = new Student("John Doe", 15, "8th");
			Student student2 = new Student("Chemsou suno", 20, "11th");

			// save the student
			studentRepository.saveAll(Arrays.asList(student, student2));

			// create three courses
			Course course1 = new Course("Machine Learning", "ML", 12, 1500);
			Course course2 = new Course("Database Systems", "DS", 8, 800);
			Course course3 = new Course("Web Basics", "WB", 10, 0);

			// save courses
			courseRepository.saveAll(Arrays.asList(course1, course2, course3));

			// add courses to the student
			student.getCourses().addAll(Arrays.asList(course1, course2, course3));
			student2.getCourses().addAll(Arrays.asList(course1, course3));

			// update the student
			studentRepository.saveAll(Arrays.asList(student, student2));

			studentRepository
					.findByNameContaining("chemsou suno")
					.forEach(s -> {
				System.out.println(s + " => " + s.getCourses());
			});

			courseRepository.findByTitleContaining("Machine Learning").forEach(s -> {
				System.out.println(s + " => " + s.getStudents());
			});
		};
	}*/

	@Bean
	public CommandLineRunner mappingDemo(BookRepository bookRepository,
										 PageRepository pageRepository) {
		return args -> {

			// create a new book
			Book book = new Book("Java 101", "John Doe", "123456");

			// save the book
			bookRepository.save(book);

			// create and save new pages
			pageRepository.save(new Page(1, "Introduction contents", "Introduction", book));
			pageRepository.save(new Page(65, "Java 8 contents", "Java 8", book));
			pageRepository.save(new Page(95, "Concurrency contents", "Concurrency", book));

//			bookRepository.findAll().forEach(item -> System.out.println(item + "=>" + item.getPages()));
			System.out.println("before delete");
			System.out.println(book);
			pageRepository.findAll().forEach(item -> System.out.println(item + "=>" + item.getBook()));
			System.out.println("after delete");
			bookRepository.delete(book);
			pageRepository.findAll().forEach(item -> System.out.println(item + "=>" + item.getBook()));
		};
	}

	/*@Bean
	public CommandLineRunner mappingDemo(PersonRepository personRepository,
										 AddressRepository addressRepository) {
		return args -> {

			// create a user instance
			Person person = new Person("John Doe", "john.doe@example.com", "1234abcd");

			// create an address instance
			Address address = new Address("Lake View 321", "Berlin", "Berlin",
					"95781", "DE");

			// set child reference
			address.setPerson(person);

			// set parent reference
			person.setAddress(address);

			// save the parent
			// which will save the child (address) as well
			personRepository.save(person);

			personRepository.findAll().forEach(item -> System.out.println(item + "=>" + item.getAddress()));
			addressRepository.findAll().forEach(item -> System.out.println(item + "=>" + item.getPerson()));

		};
	}*/

	/*@Bean
	public CommandLineRunner mappingDemo(Person_Repository person_Repository,
										 Address_Repository address_Repository) {
		return args -> {

			// create a user instance
			Person_ person_ = new Person_("John Doe");

			// create an address instance
			Address_ address_ = new Address_("Lake View 321", 15, "Berlin", 95781);

			*//** CascadeType.PERSIST *//*
			*//*person_.setAddresses_(Arrays.asList(address_));
			address_.setPerson_(person_);

			// save the parent
			// which will save the child (address) as well
			person_Repository.save(person_);

			person_Repository.findAll().forEach(item -> System.out.println(item + "=>" + item.getAddresses_()));
			address_Repository.findAll().forEach(item -> System.out.println(item + "=>" + item.getPerson_()));*//*
			*//** END *//*

			*//** CascadeType.MERGE *//*
			person_.setAddresses_(Arrays.asList(address_));
			address_.setPerson_(person_);

			// save the parent
			// which will save the child (address) as well
			person_ = person_Repository.saveAndFlush(person_);

			System.out.println("before merge");
			person_Repository.findAll().forEach(item -> System.out.println(item + "=>" + item.getAddresses_()));
			address_Repository.findAll().forEach(item -> System.out.println(item + "=>" + item.getPerson_()));

			person_.setName("chemsou");
			person_.getAddresses_().get(0).setCity("Alger");
			person_Repository.saveAndFlush(person_);
			System.out.println("after merge");
			person_Repository.findAll().forEach(item -> System.out.println(item + "=>" + item.getAddresses_()));
			address_Repository.findAll().forEach(item -> System.out.println(item + "=>" + item.getPerson_()));
			*//** END *//*


		};
	}*/
}
