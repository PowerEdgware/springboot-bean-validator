package com.study;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.pojo.MockUser;

@RestController
public class UserController {

	ConcurrentMap<String, MockUser> users=new ConcurrentHashMap<>();
	@GetMapping("/u/save")
	public String saveUser(@Valid MockUser user) {
//		System.out.println(bindingResult);
//		if(bindingResult.hasErrors()) {
//			return "ERR";
//		}
		users.putIfAbsent(user.getName(), user);
		return "OK";
	}
	
	@GetMapping("/u/get")
	public MockUser getUser(@Valid@NotNull String userName) {
		return users.get(userName);
	}
}
