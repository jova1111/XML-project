package com.otkudznam.booking.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.otkudznam.booking.model.Agent;

@Repository
public interface AgentRepository extends PagingAndSortingRepository<Agent, Long>{

	List<Agent> findAll();
}
