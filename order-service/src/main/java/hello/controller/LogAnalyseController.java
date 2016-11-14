package hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogAnalyseController {

	@RequestMapping("/")
	public String home() {
		return "Elasticsearch - Simple Logging Application";
	}

}
