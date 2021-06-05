package com.sad.bus.futa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sad.bus.futa.entity.FutaTickets;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class BusFutaController {
	@Autowired
	private Environment env;

	@RequestMapping("/")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of image service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from Image Service running at port: " + env.getProperty("local.server.port");
	}
	
//	public List<Object> callFuta() {
//		List<Object> futaTickets = restTemplate.getForObject("http://localhost:1062/search-vexere/ticket/1", List.class);
//		return futaTickets;
//	}
	
	@RequestMapping("/futa-ticket")
	public List<FutaTickets> getTickets() {
		List<FutaTickets> getTickets = Arrays.asList(
			new FutaTickets(1, "nha xe phương trang", "11/11/2021","293 đinh bộ lĩnh", 100000L),
			new FutaTickets(2, "nha xe phương trang 1", "12/11/2021","123 nguyễn xí", 200000L),
			new FutaTickets(3, "nha xe phương trang 2", "13/11/2021","321 chu van an", 200000L));
		return getTickets;
	}
}