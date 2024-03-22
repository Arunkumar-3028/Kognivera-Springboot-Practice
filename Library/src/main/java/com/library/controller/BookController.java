package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.beans.Book;
import com.library.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	BookService bookService;

	@PostMapping()
	public String Addbook(@RequestBody Book book) {
		bookService.SaveBook(book);
		return "Book Saved";
	}

	@GetMapping("/getallbook")
	public List<Book> getallbook() {
		return bookService.fetchallbooks();
	}

	@GetMapping("/findbyid/{id}")
	public Book findbookbyid(@PathVariable("id") Integer id) {
		return bookService.findbyid(id);
	}

	@GetMapping("/findbyauthor/{author}")
	public List<Book> findbookbyauthor(@PathVariable("author") String author) {
		return bookService.findbyauthor(author);
	}

	@GetMapping("/findbytitle/{title}")
	public Book findbookbytitle(@PathVariable("title") String title) {
		return bookService.findbytitle(title);
	}

	@DeleteMapping("/deletebyid/{id}")
	public String deletebyid(@PathVariable("id") Integer id) {
		bookService.deletebyid(id);
		return "book deleted";
	}
	

}
