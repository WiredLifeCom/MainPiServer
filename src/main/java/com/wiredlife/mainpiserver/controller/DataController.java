package com.wiredlife.mainpiserver.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import spark.Request;
import spark.Response;

import com.wiredlife.jsonformatjava.model.Data;

public class DataController {

	public Response handleDataPost(Request req, Response res) throws IOException {
		System.out.println("Hello handlePostData");

		String json = req.body();
		System.out.println(json);
		
		Data data = Data.fromJson(json);

		File dataDir = new File(String.format("data/%s", data.getUser().getUsername()));
		dataDir.mkdirs();

		File jsonFile = new File(String.format("data/%s/%s.json", data.getUser().getUsername(), data.getUnload().toString().replace(":", "-")));

		try (BufferedWriter output = new BufferedWriter(new FileWriter(jsonFile))) {
			output.write(json);
			output.close();
		} catch (Exception e) {
			res.status(500);
			res.body(e.toString());
			return res;
		}

		res.status(200);

		return res;
	}

}
