package com.wiredlife.mainpiserver.controller;

import java.util.Map;

import spark.Request;
import spark.Response;

import com.wiredlife.jsonformatjava.dba.unload.UnloadDBA;
import com.wiredlife.jsonformatjava.model.unload.Unload;
import com.wiredlife.mainpiserver.config.Config;

public class UnloadController {

	private Map<String, String> values;

	public UnloadController() {
		this.values = Config.getValues();
	}

	public Response handleUnloadPost(Request req, Response res) {
		// System.out.println("Hello handleUnloadPost");

		String json = req.body();
		// System.out.println(json);

		Unload data = Unload.fromJson(json);

		UnloadDBA dba = new UnloadDBA(this.values.get("-database"));
		dba.addUnload(data);

		res.status(200);

		return res;
	}

}
