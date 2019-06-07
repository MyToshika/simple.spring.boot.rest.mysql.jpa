package com.mytoshika.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mytoshika.entity.User;
import com.mytoshika.service.UserService;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String createNewUser(@RequestBody User user) {
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			return ("There is already a user registered with the email provided");
		}

		userService.saveUser(user);
		return "successMessage: User has been registered successfully";
	}

	@RequestMapping(value = "/getUser/{email}", method = RequestMethod.GET)
	public User createNewUser(@PathVariable String email) {
		User user = userService.findUserByEmail(email);

		return user;
	}
}
