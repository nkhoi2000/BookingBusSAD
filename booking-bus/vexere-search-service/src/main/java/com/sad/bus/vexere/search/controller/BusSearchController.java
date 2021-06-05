package com.sad.bus.vexere.search.controller;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sad.bus.vexere.search.entity.BookingTicket;
import com.sad.bus.vexere.search.entity.VexereTickets;
import com.sad.bus.vexere.search.service.TicketSearchService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class BusSearchController {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private TicketSearchService ticketSearchService;

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
		return ticketSearchService.callVexere();
	}
	
	// -------- Admin Area --------
	// This method should only be accessed by users with role of 'admin'
	// We'll add the logic of role based auth later
	@RequestMapping("/admin")
	public String homeAdmin() {
		return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
	}
}