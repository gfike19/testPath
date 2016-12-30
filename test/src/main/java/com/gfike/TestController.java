package com.gfike;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
		public String index () {
			return "index";
		}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String index (HttpServletRequest request) {
		String words = request.getParameter("words");
		return String.format("redirect:index%s", words);
	}
	
	@RequestMapping(value="/index{words}", method = RequestMethod.GET)
	public String index(@PathVariable String words) {
		return "index";
	}
	
	@RequestMapping(value="/error", method = RequestMethod.GET)
	public String error () {
		return "error";
	}
	}

                           