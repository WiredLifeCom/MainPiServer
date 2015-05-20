package com.wiredlife.mainpiserver.controller;

import java.util.Map;

import spark.Request;
import spark.Response;

import com.wiredlife.jsonformatjava.dba.DBA;
import com.wiredlife.jsonformatjava.model.status.OnlineStatus;
import com.wiredlife.jsonformatjava.model.unload.Unload;
import com.wiredlife.mainpiserver.config.Config;

public class StatusController extends AbstractController {
	
	public StatusController() {
		
	}
	
	public Response handleOnlineStatusPost(Request request, Response response) {
		// System.out.println("Hello handleOnlineStatusPost");

		String json = request.body();
		// System.out.println(json);
		
		OnlineStatus onlineStatus = OnlineStatus.fromJson(json);

		DBA dba = new DBA(super.values.get("-database"));
		dba.addOnlineStatus(onlineStatus);

		response.status(200);

		return response;
	}
	
}
