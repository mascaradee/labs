package springmvc.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringTestController {
	private static final Logger logger = LoggerFactory.getLogger(SpringTestController.class);

	@GetMapping(path = "/test/get.do")
	public ModelAndView get(ModelAndView mv) {
		
		System.out.println("get test");
		
		mv.setViewName("/test/test");

		return mv;
	}
	
	@PostMapping(path = "/test/register.do")
	public ModelAndView register(ModelAndView mv, HttpServletRequest request) throws IOException {
		
		System.out.println("post test");
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("name"));
		
		logger.debug("{}", "post test");
		logger.debug("{}: {}", "id", request.getParameter("id"));
		logger.debug("{}: {}", "name", request.getParameter("name"));
		
		
		mv.setViewName("/test/registComplete");
		return mv;
	}
	
	public static void main(String[] args) {
		logger.trace("{}", "main test");
		
	}
	 
}
