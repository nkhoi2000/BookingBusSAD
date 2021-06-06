package com.sad.bus.vexere.search.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sad.bus.vexere.search.service.TicketSearchService;

import java.util.List;

@RestController
@RequestMapping("/")
public class BusSearchController {
	@Autowired
	private Environment env;


	@RequestMapping("/")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of gallery service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from Gallery Service running at port: " + env.getProperty("local.server.port");
	}

	// call all tickets
	@RequestMapping(value = "/ticket", method = RequestMethod.GET)
	public List<Object> getTicket(){
		return TicketSearchService.callVexere();
	}
	
	// -------- Admin Area --------
	// This method should only be accessed by users with role of 'admin'
	// We'll add the logic of role based auth later
	@RequestMapping("/admin")
	public String homeAdmin() {
		return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
	}
}