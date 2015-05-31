package com.wiredlife.mainpiserver.controller;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Map;

import com.wiredlife.jsonformatjava.dao.DAO;
import com.wiredlife.mainpiserver.config.Config;

public abstract class AbstractController {

	protected Map<String, String> values;
	protected DAO dba;

	protected AbstractController() {
		System.out.println("Initialized AbstractController");

		this.values = Config.getValues();
		try {
			this.dba = new DAO(this.values.get("-database"));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
			return;
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
	}

}
