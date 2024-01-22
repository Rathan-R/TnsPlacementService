package com.example.PlacementService;

import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class PlacementService 

{
  @Autowired
  private PlacementRepository repo;
        
      public List<Placement> listAll()
      {
    	  return (List<Placement>) repo.findAll();
      }
      
      public void save(Placement admin)
      {
    	  repo.save(admin);
      }
      
      public Placement get(Integer Id)
      {
    	  return repo.findById(Id).get();
      }
      
      public void delete(Integer Id)
      {
    	  repo.deleteById(Id);
      }
  
}
