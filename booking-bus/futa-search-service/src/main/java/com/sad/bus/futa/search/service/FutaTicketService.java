package com.sad.bus.futa.search.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sad.bus.futa.search.entity.FutaTickets;

@Component
public class FutaTicketService {

	public static List<Object> callFuta() {
		List<Object> getTickets = Arrays.asList(
				new FutaTickets(1, "nha xe phương trang", "11/11/2021","293 đinh bộ lĩnh", 100000L),
				new FutaTickets(2, "nha xe phương trang 1", "12/11/2021","123 nguyễn xí", 200000L),
				new FutaTickets(3, "nha xe phương trang 2", "13/11/2021","321 chu van an", 200000L));
		return getTickets;
	}
}
