package com.idwebapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario", catalog = "idwebapp")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre", length = 500, nullable = false)
    private String nombre;
	
	@Column(name = "usuario", length = 100, nullable = false, unique = true)
    private String usuario;
	
	@Column(name = "clave", length = 500, nullable = false)
    private String clave;
	
	@Column(name = "habilitado", nullable = false)
    private boolean habilitado;
	
}
