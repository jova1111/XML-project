package com.otkudznam.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otkudznam.booking.model.Agent;
import com.otkudznam.booking.repository.AgentRepository;

@Service
public class AgentServiceImp implements AgentService{

	@Autowired
	private AgentRepository agentRepository;
	
	 @Override
	    public void saveOrUpdate(Agent agent) {
		 agentRepository.save(agent);
	    }

	    @Override
	    public List<Agent> findAll() {
	        return agentRepository.findAll();
	    }
}
