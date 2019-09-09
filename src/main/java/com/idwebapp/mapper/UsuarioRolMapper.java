package com.idwebapp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.idwebapp.model.Rol;
import com.idwebapp.model.Usuario;
import com.idwebapp.model.UsuarioRol;

public class UsuarioRolMapper implements RowMapper<UsuarioRol>{

	@Override
	public UsuarioRol mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Usuario usuario = Usuario.builder().id(rs.getInt("usuario_id"))
				.nombre(rs.getString("nombre")).usuario("usuario").clave("clave")
				.habilitado(rs.getBoolean("habilitado")).build();
		
		Rol rol = Rol.builder().id(rs.getInt("rol_id")).rol(rs.getString("rol")).build();
		
		return UsuarioRol.builder().id(rs.getInt("usuario_rol_id")).usuarioId(usuario).rol(rol).build();
	}

}
