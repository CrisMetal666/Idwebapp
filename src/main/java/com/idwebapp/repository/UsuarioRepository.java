package com.idwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.idwebapp.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("select u.nombre from Usuario u where u.usuario = ?1")
	String buscarNombrePorUsuario(String usuario);
}
