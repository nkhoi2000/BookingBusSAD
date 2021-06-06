package com.sad.bus.futa.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sad.bus.futa.entity.FutaTickets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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

	@RequestMapping("/futa-ticket")
	public FutaTickets[] getTickets() throws Exception {
		URL url = new URL("http://localhost:1162/search-futa/ticket");
		HttpURLConnection _conn = (HttpURLConnection) url.openConnection();

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
		return gson.fromJson(content.toString(), FutaTickets[].class);
	}
}