package com.sad.bus.vexere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sad.bus.vexere.entity.VexereTickets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

@RestController
@RequestMapping("/")
public class BusVexereController {
	@Autowired
	private Environment env;

	@RequestMapping("/")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of image service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from Image Service running at port: " + env.getProperty("local.server.port");
	}

	@RequestMapping("/vexere-ticket")
	public VexereTickets[] getTickets() throws Exception {
		URL url = new URL("http://localhost:1062/search-vexere/ticket");
		HttpsURLConnection _conn = (HttpsURLConnection) url.openConnection();

		// request config
		_conn.setRequestMethod("GET");

		BufferedReader inputReader = new BufferedReader(new InputStreamReader(_conn.getInputStream()));
		String line;
		StringBuilder content = new StringBuilder();
		while (((line = inputReader.readLine()) != null)) {
			content.append(line);
		}
		inputReader.close();
		Gson gson = new Gson();
		return gson.fromJson(content.toString(), VexereTickets[].class);
	}

//	@RequestMapping("/vexere-ticket")
//	public List<VexereTickets> getTickets() {
//		List<VexereTickets> getTickets = Arrays.asList(
//			new VexereTickets(1, "vexere", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3842005760","abc",100000L),
//			new VexereTickets(2, "vexere 1", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3698134272","bcb",100000L),
//			new VexereTickets(3, "vexere 2", "https://www.imdb.com/title/tt0096697/mediaviewer/rm1445594112","bcb",100000L));
//		return getTickets;
//	}
}