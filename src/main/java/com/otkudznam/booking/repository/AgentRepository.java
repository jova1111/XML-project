package com.otkudznam.booking.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.otkudznam.booking.model.Agent;

public interface AgentRepository extends PagingAndSortingRepository<Agent, Long>{

	List<Agent> findAll();
}
