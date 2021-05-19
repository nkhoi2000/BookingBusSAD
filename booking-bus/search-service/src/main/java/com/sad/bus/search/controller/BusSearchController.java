package com.sad.bus.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sad.bus.search.entity.BookingTicket;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class BusSearchController {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;
	
	@RequestMapping("/")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of gallery service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from Gallery Service running at port: " + env.getProperty("local.server.port");
	}
  
	@RequestMapping("/futa/{id}")
	public BookingTicket getFutaTicket(@PathVariable final int id) {
		// create gallery object
		BookingTicket gallery = new BookingTicket();
		gallery.setId(id);
		
		// get list of available images 
		List<Object> images = restTemplate.getForObject("http://futa/futa-ticket/", List.class);
		gallery.setTickets(images);
		return gallery;
	}
	
	//call vexere
	@RequestMapping("/vexere/{id}")
	public BookingTicket getVexereTicket(@PathVariable final int id) {
		// create gallery object
		BookingTicket gallery = new BookingTicket();
		gallery.setId(id);
		
		// get list of available images 
		List<Object> images = restTemplate.getForObject("http://vexere/vexere-ticket/", List.class);
		gallery.setTickets(images);
		return gallery;
	}
	
	//call all tickets
	@RequestMapping("/ticket/{id}")
	public BookingTicket getAllTicket(@PathVariable final int id) {
		// create gallery object
		BookingTicket gallery = new BookingTicket();
		gallery.setId(id);
		
		// get list of available images 
		ArrayList<Object> images = new ArrayList<>();
		images.add(getFutaTicket(id));
		images.add(getVexereTicket(id));
		
		gallery.setTickets(images);
	
		return gallery;
	}
	// -------- Admin Area --------
	// This method should only be accessed by users with role of 'admin'
	// We'll add the logic of role based auth later
	@RequestMapping("/admin")
	public String homeAdmin() {
		return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
	}
}