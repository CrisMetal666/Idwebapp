package com.idwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idwebapp.service.IUsuarioRolService;

@RestController
@RequestMapping("/usuario-rol/")
public class UsuarioRolController {

	@Autowired
	private IUsuarioRolService service;

	@GetMapping
	public ResponseEntity<?> buscarTodos() {

		return new ResponseEntity<>(service.buscarTodos(), HttpStatus.OK);
	}

	@GetMapping(path = "dao")
	public ResponseEntity<?> buscarTodosDao() {

		return new ResponseEntity<>(service.buscarTodosDao(), HttpStatus.OK);
	}
}
