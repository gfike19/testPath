package com.gfike;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	//when the page is first loaded
	@RequestMapping(value="/", method = RequestMethod.GET)
		public String index () {
			return "index";
		}
	
	//when the user enters text
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String index (HttpServletRequest request) {
		String words = request.getParameter("words");
		return String.format("redirect:index%s", words);
	}
	
	//page is reloaded with text that was entered
	@RequestMapping(value="/index{words}", method = RequestMethod.GET)
	public String index(@PathVariable String words,Model model) {
		String msg = "The last message entered was: " + words;
		model.addAttribute("msg", msg);
		return "index";
	}
	
	//when text is added again
	@RequestMapping(value="/index{words}", method = RequestMethod.POST)
	public String indexPathPost(HttpServletRequest request) {
		String words = request.getParameter("words");
		return String.format("redirect:index%s", words);
	}
	
	
	@RequestMapping(value="/error", method = RequestMethod.GET)
	public String error () {
		return "error";
	}
	}

                           