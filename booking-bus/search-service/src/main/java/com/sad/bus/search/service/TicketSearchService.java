package com.sad.bus.search.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class TicketSearchService {
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallbackFuta")
	public List<Object> callFuta() {
		List<Object> futaTickets = restTemplate.getForObject("http://futa/futa-ticket/", List.class);
		return futaTickets;
	}

	@HystrixCommand(fallbackMethod = "fallbackVexere")
	public List<Object> calVexere() {
		List<Object> vexereTickets = restTemplate.getForObject("http://vexere/vexere-ticket/", List.class);
		return vexereTickets;
	}

	public List<Object> fallbackFuta(Throwable hystrixCommand) {
		return new ArrayList<>();
	}

	public List<Object> fallbackVexere(Throwable hystrixCommand) {
		return new ArrayList<>();
	}
}
