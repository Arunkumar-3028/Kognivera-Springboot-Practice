package com.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.library.beans.Book;
import com.library.beans.User;

@Service
public class UserService {

	public List<User> users = new ArrayList<User>();
	BookService bs =new BookService();
	

	public void saveUser(User u) {
		users.add(u);
	}
	
	public void takebook(Integer userid, Integer bookid ) {
		
		for(User u:users) {
			if(u.getId()==userid) {
				for(Book b:bs.fetchallbooks()) {
					if(b.getId()==bookid) {
						u.getBooks().add(b);
					}
				}
			}
		}
	}

	public List<User> fetchalluser() {
		return users;
	}

	public User findbyid(Integer id) {
		for (User u : users) {
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
	}

	public List<User> findbyname(String name) {
		List<User> li = new ArrayList<User>();
		for (User u : users) {
			if (u.getName().equals(name)) {
				li.add(u);
			}
		}
		return li;
	}

	public void deletebyid(Integer id) {
		for (User u : users) {
			if (u.getId() == id) {
				users.remove(u);
			}
		}
	}

}
