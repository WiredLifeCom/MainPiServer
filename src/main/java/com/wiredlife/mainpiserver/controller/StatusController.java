package com.wiredlife.mainpiserver.controller;

import java.sql.SQLException;

import spark.Request;
import spark.Response;

import com.google.gson.JsonParseException;
import com.wiredlife.jsonformatjava.model.status.OnlineStatus;

public class StatusController extends AbstractController {

	public StatusController() {
		System.out.println("Initialized StatusController");
	}

	public Response handleOnlineStatusPost(Request request, Response response) {
		// System.out.println("Hello handleOnlineStatusPost");

		String json = request.body();
		// System.out.println(json);

		OnlineStatus onlineStatus;
		try {
			onlineStatus = OnlineStatus.fromJson(json);
		} catch (JsonParseException e) {
			response.status(422);
			return response;
		}

		try {
			super.dba.addOnlineStatus(onlineStatus);
		} catch (SQLException e) {
			response.status(400);
			return response;
		}

		response.status(200);
		return response;
	}

}
