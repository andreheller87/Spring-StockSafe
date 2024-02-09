package com.stocksafe.course.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocksafe.course.entities.Usuario;

@RestController
@RequestMapping(value= "/users")
public class UserResource {
	
	    @GetMapping
		public ResponseEntity<Usuario> findAll(){
			Usuario use = new Usuario(1L,"André","123456",1);
		return ResponseEntity.ok().body(use);
		}
}
