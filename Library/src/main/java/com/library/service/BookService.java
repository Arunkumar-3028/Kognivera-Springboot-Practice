package com.library.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import com.library.beans.Book;

@Service
public class BookService {
	
	public List<Book> books= new ArrayList<Book>();

	public void SaveBook(Book book) {
		books.add(book);
	}

	public List<Book> fetchallbooks() {
		return books;
	}

	public Book findbyid(Integer id) {
		for (Book bk : books) {
			if (bk.getId() == id) {
				return bk;
			}
		}
		return null;
	}

	public Book findbytitle(String title) {
		for (Book bk : books) {
			if (bk.getTitle().equals(title)) {
				return bk;
			}
		}
		return null;
	}

	public List<Book> findbyauthor(String author) {
		List<Book> li = new ArrayList<Book>();
		for (Book bk : books) {
			if (bk.getAuthor().equals(author)) {
				li.add(bk);
			}
		}
		return li;
	}
	public void deletebyid(Integer id) {
		for (Book bk : books) {
			if (bk.getId() == id) {
				books.remove(bk);
			}
		}
	}

	

}
