package com.sad.bus.vexere.search.entity;

public class VexereTickets {
	private Integer id;
    private String name;
    private String departureDay;
    private String departureAddress;
    private Long price;
    
	public VexereTickets(Integer id, String name, String departureDay, String departureAddress, Long price) {
		super();
		this.id = id;
		this.name = name;
		this.departureDay = departureDay;
		this.departureAddress = departureAddress;
		this.price = price;
	}
	
	public String getDepartureAddress() {
		return departureAddress;
	}
	
	public void setDepartureAddress(String departureAddress) {
		this.departureAddress = departureAddress;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDepartureDay() {
		return departureDay;
	}
	
	public void setDepartureDay(String departureDay) {
		this.departureDay = departureDay;
	}
	
	public Long getPrice() {
		return price;
	}
	
	public void setPrice(Long price) {
		this.price = price;
	}

}
