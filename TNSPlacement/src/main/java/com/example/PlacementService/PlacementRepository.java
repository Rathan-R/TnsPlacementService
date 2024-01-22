package com.example.PlacementService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacementRepository extends CrudRepository<Placement, Integer>{
	
}