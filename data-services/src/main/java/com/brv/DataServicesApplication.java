package com.brv;

import java.util.Arrays;

import javax.xml.crypto.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brv.model.Book;
import com.brv.repository.BookRepository;

@SpringBootApplication
public class DataServicesApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DataServicesApplication.class, args);
	}

	@Autowired
	private BookRepository repository;
	
	private static final Logger log = LoggerFactory.getLogger(DataServicesApplication.class);
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		log.info("DB App started - Record creation Initiated");
		
		repository.save(new Book("Spark"));
		repository.save(new Book("Scala"));
		repository.save(new Book("GoLang"));
		repository.save(new Book("Phyton"));
		repository.save(new Book("Javascript"));
		repository.save(new Book("Java"));
		repository.save(new Book("Erlang"));
		
		System.out.println("\n find all records");
		
		repository.findAll().forEach(p -> System.out.println(p));
		
		System.out.println("\n find by id ");
		
		repository.findById(6L).ifPresent(p -> System.out.println(p));
		
		System.out.println("\n find by name ");
		
		repository.findByName("Erlang").forEach(p -> System.out.println(p));
		
		
		System.out.println("\n update record ");

		repository.findById(4L).ifPresent(p -> {
			System.out.println(p);
			p.setName("Html");
			repository.save(p);
		});
		
		
		/*
		 * System.out.println("\n Delete Book by Id");
		 * 
		 * Book booktoDelete = repository.findById(7L).get();
		 * repository.delete(booktoDelete);
		 */
		
		/*
		 * System.out.println("\n Delete Book by Name");
		 * repository.findByName("Java").forEach(book ->{
		 * System.out.println("deleting book "+book.getName()); repository.delete(book);
		 * });
		 */
		
		/*
		 * System.out.println("delete by id"); repository.deleteById(10L);
		 */
		
		/*
		 * System.out.println("batch deletion by Id's");
		 * repository.deleteAllById(Arrays.asList(1L,3L,6L));
		 */
		
		/*
		 * System.out.println("delete by Name");
		 * repository.deleteAll(repository.findByName("Erlang"));
		 */
		
		
		  System.out.println("\n Find by Name1 Records");
		  repository.findByName1("Spark").forEach(p -> System.out.println(p));
		 
	}

}
