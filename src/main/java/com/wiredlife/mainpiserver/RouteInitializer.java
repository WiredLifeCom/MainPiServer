package com.wiredlife.mainpiserver;

import static spark.Spark.post;
import static spark.SparkBase.port;

import java.util.Arrays;
import java.util.List;

import com.wiredlife.mainpiserver.config.Config;
import com.wiredlife.mainpiserver.controller.UnloadController;

public class RouteInitializer {

	private UnloadController unloadController;

	public RouteInitializer() {
		this.unloadController = new UnloadController();
	}

	public void createRoutes() {
		post("/unload", (req, res) -> this.unloadController.handleUnloadPost(req, res));
	}

	public static void main(String[] args) {
		List<String> argsList = Arrays.asList(args);

		if (argsList.contains("-port")) {
			Config.setPort(Integer.parseInt(argsList.get(argsList.indexOf("-port") + 1)));
		} else {
			Config.setPort(7070);
		}

		if (argsList.contains("-database")) {
			Config.setDatabase(argsList.get(argsList.indexOf("-database") + 1));
		} else {
			Config.setDatabase("database.sqlite");
		}

		port(Config.getPort());

		RouteInitializer initializer = new RouteInitializer();
		initializer.createRoutes();
	}

}
