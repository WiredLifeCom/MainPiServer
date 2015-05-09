package com.wiredlife.mainpiserver.config;

public class Config {

	private static int port;
	private static String database;

	public static int getPort() {
		return port;
	}

	public static void setPort(int port) {
		Config.port = port;
	}

	public static String getDatabase() {
		return database;
	}

	public static void setDatabase(String database) {
		Config.database = database;
	}

}
