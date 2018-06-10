package com.otkudznam.booking.service;

import java.util.List;

import com.otkudznam.booking.model.Agent;

public interface AgentService {

	void saveOrUpdate(Agent agent);
    List<Agent> findAll();
	
}
