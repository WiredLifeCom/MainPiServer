package com.wiredlife.mainpiserver;

import static spark.Spark.post;
import static spark.SparkBase.port;

import java.util.Map;

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
		Map<String, String> values = Config.getValues();

		for (int i = 0; i < args.length - 1; i++) {
			if (i % 2 == 0) {
				values.put(args[i], args[i + 1]);
			}
		}

		port(Integer.valueOf(values.get("-port")));

		RouteInitializer initializer = new RouteInitializer();
		initializer.createRoutes();
	}

}
