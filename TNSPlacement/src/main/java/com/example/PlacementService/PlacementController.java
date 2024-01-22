package com.example.PlacementService;

import jakarta.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlacementController 
{
  @Autowired(required=true)
  private PlacementService service;
  
  @GetMapping("/selectAll")
  public java.util.List<Placement> list()
  {
	  return service.listAll();
  }
  @GetMapping("/select/{Id}")
  public ResponseEntity <Placement> get(@PathVariable Integer Id)
  {
	  try
	  {
		Placement pls = service.get(Id);
		return new ResponseEntity<Placement>(pls,HttpStatus.OK);
	  }
	  catch(NoResultException e)
	  {
		  return new ResponseEntity<Placement>(HttpStatus.NOT_FOUND);
	  }
   
  }

  @PostMapping("/insert")
  public String add(@RequestBody Placement pls)
  {
	  service.save(pls);
	  return "added Successfully"; 
  }


  @PutMapping("/updte/{pls_Id}")
	public ResponseEntity<?> update(@RequestBody Placement updatedStudent, @PathVariable Integer pls_Id) {
		Placement existingStudent = service.get(pls_Id);

		if (existingStudent != null) {
			existingStudent.setName(updatedStudent.getName());
			service.save(existingStudent);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
  @DeleteMapping("/delete/{pls_Id}")
  public void delete (@PathVariable Integer pls_Id)
  {
	  service.delete(pls_Id);
  }
   
}
