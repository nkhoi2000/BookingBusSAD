package com.sad.bus.futa.search.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sad.bus.futa.search.entity.FutaTickets;

@Component
public class FutaTicketService {

	public static List<Object> callFuta() {
		List<Object> getTickets = Arrays.asList(
				new FutaTickets(1, "nha xe phuong trang", "11/11/2021","BX Miền Tây", 200000L),
				new FutaTickets(2, "nha xe phuong trang 1", "12/11/2021","BX An Sương", 200000L),
				new FutaTickets(3, "nha xe phuong trang 2", "11/11/2021","BX An Sương", 200000L),
				new FutaTickets(4, "nha xe phuong trang 3", "11/11/2021","Hàng Xanh", 150000L),
				new FutaTickets(5, "nha xe phuong trang 4", "11/11/2021","BX Miền Đông", 200000L),
				new FutaTickets(6, "nha xe phuong trang 5", "13/11/2021","BX Miền Tây", 200000L),
				new FutaTickets(7, "nha xe phuong trang 6", "11/11/2021","BX Miền Tây", 300000L),
				new FutaTickets(8, "nha xe phuong trang 7", "12/11/2021","BX Miền Đông", 150000L),
				new FutaTickets(9, "nha xe phuong trang 8", "11/11/2021","BX An Sương", 200000L),
				new FutaTickets(10, "nha xe phuong trang 9", "12/11/2021","Ngã tư Thủ Đức", 200000L));
		return getTickets;
	}
}
