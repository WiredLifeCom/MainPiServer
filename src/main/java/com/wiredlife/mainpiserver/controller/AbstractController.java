package com.wiredlife.mainpiserver.controller;

import java.util.Map;

import com.wiredlife.mainpiserver.config.Config;

public abstract class AbstractController {

	protected Map<String, String> values;
	
	protected AbstractController() {
		this.values = Config.getValues();
	}
	
}
