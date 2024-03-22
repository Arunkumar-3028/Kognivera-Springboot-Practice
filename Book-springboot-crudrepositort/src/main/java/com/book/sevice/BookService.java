package com.book.sevice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.beans.Book;
import com.book.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public void savebook(Book book) {
		bookRepository.save(book);
		
	   log.info("indside the create method");
	}

	public List<Book> getallbooks() {
		List<Book> book = new ArrayList<Book>();
		bookRepository.findAll().forEach(book1 -> book.add(book1));
		   log.info("indside the get all method");

		return book;
	}

	public Book getbyid(int id) {
		   log.info("indside the get by id method");

		return bookRepository.findById(id).get();
	}

	public void saveorupdate(Book book) {
		   log.info("indside the update method");

		bookRepository.save(book);
	}

	public void deletebyid(int id) {

		log.info("indside the delete method");

		bookRepository.deleteById(id);
	}

}
