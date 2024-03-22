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

import com.library.beans.User;
import com.library.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {
	@Autowired
	UserService service;

	@PostMapping()
	public String Adduserk(@RequestBody User user) {
		service.saveUser(user);
		return "User Saved";
	}

	@GetMapping("/getalluser")
	public List<User> getalluser() {
		return service.fetchalluser();
	}

	@GetMapping("/findbyid/{id}")
	public User finduserbyid(@PathVariable("id") Integer id) {
		return service.findbyid(id);
	}

	@GetMapping("/findbyname/{name}")
	public List<User> findbookbyname(@PathVariable("name") String name) {
		return service.findbyname(name);
	}

	@DeleteMapping("/deletebyid/{id}")
	public String deletebyid(@PathVariable("id") Integer id) {
		service.deletebyid(id);
		return "User deleted";
	}

	@PostMapping("/takebook/{userid}/{bookid}")
	public String addbookforuser(@PathVariable("userid") Integer userid,@PathVariable("bookid") Integer bookid) {
		service.takebook(userid, bookid);
		return "booktaken";
	}
}
