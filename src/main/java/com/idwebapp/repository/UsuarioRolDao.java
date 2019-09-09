package com.idwebapp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.idwebapp.mapper.UsuarioRolMapper;
import com.idwebapp.model.UsuarioRol;

@Repository
public class UsuarioRolDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<UsuarioRol> buscarTodos() {

		String sql = "select u.id as usuario_id, u.nombre, u.usuario, u.clave, u.habilitado,"
				+ "ur.id as usuario_rol_id, r.id as rol_id, r.rol from usuario_roles ur inner"
				+ " join usuario u on u.id = ur.usuario_id inner join rol r on r.id = ur.rol_id";

		return jdbcTemplate.query(sql, new UsuarioRolMapper());
	}
}
