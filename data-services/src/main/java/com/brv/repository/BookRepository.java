package com.brv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.brv.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	
	List<Book> findByName(String name);
	
    @Query("select u from Book u where u.name = :name")
    List<Book> findByName1(String name);
	 
}
