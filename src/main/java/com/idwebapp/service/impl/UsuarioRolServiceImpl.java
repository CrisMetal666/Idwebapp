package com.idwebapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idwebapp.model.UsuarioRol;
import com.idwebapp.repository.IUsuarioRolRepository;
import com.idwebapp.repository.UsuarioRolDao;
import com.idwebapp.service.IUsuarioRolService;

@Service
public class UsuarioRolServiceImpl implements IUsuarioRolService {

	@Autowired
	private IUsuarioRolRepository repo;

	@Autowired
	private UsuarioRolDao dao;

	@Override
	public List<UsuarioRol> buscarTodos() {

		/*
		 * 
		 * TODA LA LOGICA DE NEGOCIO
		 * 
		 */

		return repo.buscarTodos();
	}

	@Override
	public List<UsuarioRol> buscarTodosDao() {

		/*
		 * 
		 * TODA LA LOGICA DE NEGOCIO
		 * 
		 */

		return dao.buscarTodos();
	}

}
