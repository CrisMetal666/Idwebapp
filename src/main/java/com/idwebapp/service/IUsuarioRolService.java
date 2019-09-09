package com.idwebapp.service;

import java.util.List;

import com.idwebapp.model.UsuarioRol;

public interface IUsuarioRolService {

	List<UsuarioRol> buscarTodos();
	
	List<UsuarioRol> buscarTodosDao();
}
