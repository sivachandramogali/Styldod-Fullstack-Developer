package com.example.hackerearth.StyldodFullstackDeveloper.controller;

import com.example.hackerearth.StyldodFullstackDeveloper.bean.Teller;
import com.example.hackerearth.StyldodFullstackDeveloper.exception.TellerNotFoundException;

import com.example.hackerearth.StyldodFullstackDeveloper.service.TellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class controller {
    @Autowired
    TellerService tellerService;
  // Teller teller= new Teller(100, "AndraBank", "Samalkota", 50000);

    @RequestMapping(value = "/tellers", method = RequestMethod.GET)
    public ResponseEntity<List<Teller>> getTeller(){

        return new ResponseEntity<>(tellerService.getAllTeller(), HttpStatus.OK);
    }
    @RequestMapping(value = "/tellers/{id}", method = RequestMethod.GET)
    public Teller getTellerPathparm(@PathVariable Integer id){
        Teller teller=tellerService.getTeller(id);
        if(teller==null){
            throw new TellerNotFoundException("id-"+id);
        }
        //Hatoas
        //allTellers
       return teller ;
    }
    @RequestMapping(value = "/tellers", method = RequestMethod.POST)
    public ResponseEntity<Object> createTeller(@Valid @RequestBody Teller teller){
       Teller teller1=tellerService.createTeller(teller);
       URI location= ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(teller1.getTellerId()).toUri();
        System.out.println(location);

        /*URI location1= ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(teller1.getTellerId()).toUri();
       System.out.println(location1);*/
       return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/tellers/{id}")
    public Teller deleteUser(@PathVariable  int id){
        Teller teller  =tellerService.deleteById(id);
        if(teller==null)
            throw new TellerNotFoundException("id-"+id);
        return teller;
    }
}
