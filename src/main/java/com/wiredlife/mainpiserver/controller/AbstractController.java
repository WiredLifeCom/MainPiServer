package com.wiredlife.mainpiserver.controller;

import java.util.Map;

import com.wiredlife.jsonformatjava.dba.DBA;
import com.wiredlife.mainpiserver.config.Config;

public abstract class AbstractController {

	protected Map<String, String> values;
	protected DBA dba;
	
	protected AbstractController() {
		System.out.println("Initialized AbstractController");
		
		this.values = Config.getValues();
		this.dba = new DBA(this.values.get("-database"));
	}
	
}
