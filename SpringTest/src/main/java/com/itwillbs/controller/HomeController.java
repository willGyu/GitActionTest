package com.itwillbs.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Handles requests for the application home page.
 */
class User {
	String key;
	Object value;

	public User(String k, Object v) {
		key = k;
		value = v;
	}

	@Override
	public String toString() {
		return "User [key=" + key + ", value=" + value + "]";
	}
}

@Controller
@SessionAttributes(value = "user")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@ModelAttribute("user")
	public User createUserSession() {
		// 새로운 세션 값을 반환하면 세션에 저장됨
		return new User("defaultUser", "defaultEmail@example.com");
	}

	// http://localhost:8080/controller/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("item", "ITWILL");

		System.out.println(model.containsAttribute("item"));

		return "home";
	}

}
