package com.sad.bus.vexere.search.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sad.bus.vexere.search.entity.VexereTickets;

@Component
public class TicketSearchService {

	public List<VexereTickets> callVexere() {
		List<VexereTickets> getTickets = Arrays.asList(
				new VexereTickets(1, "vexere", "11/11/2021","293 đinh bộ lĩnh", 100000L),
				new VexereTickets(2, "vexere 1", "12/11/2021","123 nguyễn xí", 200000L),
				new VexereTickets(3, "vexere 2", "13/11/2021","321 chu van an", 200000L));
		return getTickets;
	}
}
