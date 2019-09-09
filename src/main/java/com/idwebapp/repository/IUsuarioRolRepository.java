package com.idwebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.idwebapp.model.UsuarioRol;

public interface IUsuarioRolRepository extends JpaRepository<UsuarioRol, Integer> {

	@Query("select u from UsuarioRol u")
	List<UsuarioRol> buscarTodos();
}
