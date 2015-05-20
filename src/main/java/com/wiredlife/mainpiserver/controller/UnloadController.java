package com.wiredlife.mainpiserver.controller;

import spark.Request;
import spark.Response;

import com.wiredlife.jsonformatjava.model.unload.Unload;

public class UnloadController extends AbstractController {

	public UnloadController() {
		System.out.println("Initialized UnloadController");
	}

	public Response handleUnloadPost(Request request, Response response) {
		// System.out.println("Hello handleUnloadPost");

		String json = request.body();
		// System.out.println(json);

		Unload unload = Unload.fromJson(json);

		super.dba.addUnload(unload);

		response.status(200);

		return response;
	}

}
