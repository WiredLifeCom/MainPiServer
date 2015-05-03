package com.wiredlife.mainpiserver;

import static spark.Spark.post;
import static spark.SparkBase.port;

import java.util.Arrays;
import java.util.List;

import com.wiredlife.mainpiserver.controller.DataController;

public class RouteInitializer {

	private DataController dataController;

	public RouteInitializer() {
		this.dataController = new DataController();
	}

	public void createRoutes() {
		post("/unload", (req, res) -> this.dataController.handleUnloadPost(req, res));
	}

	public static void main(String[] args) {
		List<String> argsList = Arrays.asList(args);

		int port;
		if (argsList.contains("-port")) {
			port = Integer.parseInt(argsList.get(argsList.indexOf("-port") + 1));
		} else {
			port = 7070;
		}

		port(port);

		RouteInitializer initializer = new RouteInitializer();
		initializer.createRoutes();
	}

}
