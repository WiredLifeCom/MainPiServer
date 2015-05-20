package com.wiredlife.mainpiserver.controller;

import java.util.Map;

import com.wiredlife.jsonformatjava.dao.DAO;
import com.wiredlife.mainpiserver.config.Config;

public abstract class AbstractController {

	protected Map<String, String> values;
	protected DAO dba;
	
	protected AbstractController() {
		System.out.println("Initialized AbstractController");
		
		this.values = Config.getValues();
		this.dba = new DAO(this.values.get("-database"));
	}
	
}
