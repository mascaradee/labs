package springmvc.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import springmvc.util.RequestUtil;

@Controller
public class AjaxTestController {
	private static final Logger logger = LoggerFactory.getLogger(AjaxTestController.class);

	private void doResponse(HttpServletResponse resp, String contentType, String value) throws IOException {
		resp.setStatus(200);
		resp.setContentType(contentType);
		PrintWriter out = resp.getWriter();
	    out.print(value);
	}
	
	@GetMapping(path = "/ajaxtest/getSimpleString.do")
	public void getSimpleString(HttpServletResponse resp) throws IOException {
		doResponse(resp, "text/html;charset=UTF-8", "hello mother forker?");
	}
	
	@GetMapping(path = "/ajaxtest/getSimpleJSON.do")
	public void getSimpleJSON(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String receivedData = RequestUtil.getRequestParameter(req).toString();
		logger.debug(receivedData);
		
		JsonObject object = new JsonObject();
		object.addProperty("name", "park");
		object.addProperty("age", 22);
		object.addProperty("receivedData", receivedData);
		object.addProperty("success", true);
		
		doResponse(resp, "application/json;charset=UTF-8", new Gson().toJson(object));
	}
	
	@GetMapping(path = "/ajaxtest/getLittleTinyHtml.do")
	public ModelAndView getLittleTinyHtml(ModelAndView mv) {
		mv.setViewName("/ajaxtest/littleTinyHtml");
		return mv;
	}

	@PostMapping(path = "/ajaxtest/getSimpleJSONWithPost.do")
	public void getSimpleJSONWithPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String receivedData = RequestUtil.getRequestParameter(req).toString();
		logger.debug(receivedData);
		
		JsonObject object = new JsonObject();
		object.addProperty("name", "park");
		object.addProperty("age", 22);
		object.addProperty("receivedData", receivedData);
		object.addProperty("success", true);
		
		doResponse(resp, "application/json;charset=UTF-8", new Gson().toJson(object));
	}
}
