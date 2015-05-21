package com.wiredlife.mainpiserver.controller;

import java.sql.SQLException;

import spark.Request;
import spark.Response;

import com.google.gson.JsonParseException;
import com.wiredlife.jsonformatjava.model.unload.Unload;

public class UnloadController extends AbstractController {

	public UnloadController() {
		System.out.println("Initialized UnloadController");
	}

	public Response handleUnloadPost(Request request, Response response) {
		System.out.println("Hello handleUnloadPost");

		String json = request.body();
		System.out.println(json);

		Unload unload;
		try {
			unload = Unload.fromJson(json);
		} catch (JsonParseException e) {
			e.printStackTrace();
			response.status(422);
			return response;
		}

		try {
			super.dba.addUnload(unload);
		} catch (SQLException e) {
			e.printStackTrace();
			response.status(500);
			return response;
		}

		response.status(200);
		return response;
	}

}
