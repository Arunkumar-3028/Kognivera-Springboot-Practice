package com.library.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
	private int id;
	private String title;
	private String Author;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

}
