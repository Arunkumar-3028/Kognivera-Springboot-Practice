package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.beans.Book;
import com.book.sevice.BookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/booktest")
@Slf4j
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/getallbook")
	public List<Book> getAllBooks() {
		   log.info("get all");

		return bookService.getallbooks();
	}

	@GetMapping("/getbyid/{id}")
	public Book getbyid(@PathVariable("id") int id) {
//		 log.info("get by id");
		log.debug("debugging get");
		return bookService.getbyid(id);
	}

	@PostMapping
	public String savebook(@RequestBody Book book) {
		bookService.savebook(book);
		 log.info("create book");
		return "book saved";
	}

	@PutMapping
	public String saveorupdate(@RequestBody Book book) {
		bookService.saveorupdate(book);
		 log.info("update book");
		return "book updated";
	}

	@DeleteMapping("/deletebyid/{id}")
	public String deletebyid(@PathVariable("id") int id) {
		bookService.deletebyid(id);
		 log.info("delete by id");
		return "bookdeleted";
	}

}
