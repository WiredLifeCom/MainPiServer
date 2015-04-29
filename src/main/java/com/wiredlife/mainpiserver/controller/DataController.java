package com.wiredlife.mainpiserver.controller;

import spark.Request;
import spark.Response;

import com.wiredlife.jsonformatjava.dba.unload.UnloadDBA;
import com.wiredlife.jsonformatjava.model.unload.Unload;

public class DataController {

	public Response handleUnloadPost(Request req, Response res) {
		System.out.println("Hello handleUnloadPost");

		String json = req.body();
		System.out.println(json);

		Unload data = Unload.fromJson(json);

		UnloadDBA dba = new UnloadDBA("data/database.db");
		dba.addUnload(data);

		res.status(200);

		return res;
	}

}
