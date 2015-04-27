package com.wiredlife.mainpiserver;

import static spark.Spark.post;
import static spark.SparkBase.port;

import com.wiredlife.mainpiserver.controller.DataController;

public class RouteInitializer {

	private DataController dataController;

	public RouteInitializer() {
		this.dataController = new DataController();
	}

	public void createRoutes() {
		post("/data", (req, res) -> this.dataController.handleDataPost(req, res));
	}

	public static void main(String[] args) {
		port(7070);

		RouteInitializer initializer = new RouteInitializer();
		initializer.createRoutes();
	}

}
