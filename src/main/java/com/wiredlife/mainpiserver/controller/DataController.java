package com.wiredlife.mainpiserver.controller;

import spark.Request;
import spark.Response;

import com.wiredlife.jsonformatjava.dba.SQLiteDBA;
import com.wiredlife.jsonformatjava.model.Data;

public class DataController {

	public Response handleUnloadPost(Request req, Response res) {
		System.out.println("Hello handleUnloadPost");

		String json = req.body();
		System.out.println(json);

		Data data = Data.fromJson(json);

		SQLiteDBA dba = new SQLiteDBA("data/database.db");
		dba.addUnload(data);

		System.out.println(dba.getUnloads(data.getUser().getUsername()));

		res.status(200);

		return res;
	}

}
