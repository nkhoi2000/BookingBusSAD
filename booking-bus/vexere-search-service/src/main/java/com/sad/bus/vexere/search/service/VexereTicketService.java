package com.sad.bus.vexere.search.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sad.bus.vexere.search.entity.VexereTickets;

@Component
public class VexereTicketService {

	public static List<Object> callVexere() {
		List<Object> getTickets = Arrays.asList(
				new VexereTickets(1, "Việt Nhật", "11/11/2021","Bến xe An Sương", 220000L),
				new VexereTickets(2, "Việt Nhật", "12/11/2021","Ngã Tư Thủ Đức", 250000L),
				new VexereTickets(3, "Hà Linh", "13/11/2021","Bến xe An Sương", 300000L),
				new VexereTickets(4, "Hoà Thuận Anh", "13/11/2021","Bến xe An Sương", 150000L),
				new VexereTickets(5, "Hoà Thuận Anh", "13/11/2021","Ngã Tư Thủ Đức", 200000L),
				new VexereTickets(7, "Liên Hưng", "13/11/2021","Ngã Tư Thủ Đức", 250000L),
				new VexereTickets(8, "Hà Linh", "13/11/2021","Ngã Tư Thủ Đức", 150000L),
				new VexereTickets(9, "Việt Nhật", "13/11/2021","Bến xe An Sương", 200000L),
				new VexereTickets(10, "Việt Nhật", "13/11/2021","Bến xe An Sương", 180000L));
		return getTickets;
	}	
}
